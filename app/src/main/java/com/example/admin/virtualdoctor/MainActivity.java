package com.example.admin.virtualdoctor;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import java.util.ArrayList;


public class MainActivity extends BaseActivity {
    EditText etTypingMsg;
    ImageView sendImg;
    String inputText;
    String outputText;
    ChatModel chatModel;
    Button btnInvisisble;
    String chatkey;
    String userid;
    DatabaseReference databaseReference, databaseReference2;
    FirebaseDatabase firebaseDatabase;
    RecyclerView recyclerView;
    ArrayList<ChatModel> list;
    static ArrayList<ChatModel> list2;
    MyAdapter adapter, adapter2;
    private FirebaseDatabase fdb;
    String latitude, longitude;
    static boolean calledAlready = false;
    LinearLayout linearLayout;
    static boolean scroll_down;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        this.setTitle("AI Chatbot");

        etTypingMsg = findViewById(R.id.etTypeMsg);
        sendImg = findViewById(R.id.sendImg);
        recyclerView = findViewById(R.id.myRecyclerview);
        btnInvisisble = findViewById(R.id.invisibleButton);
        linearLayout=findViewById(R.id.layout_lin);

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        /**
         *setStackFromEnd true will fill the content(list item) from the bottom of the view
         */
        mLayoutManager.setStackFromEnd(true);
       // mLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(mLayoutManager);

       // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<ChatModel>();
        list2 = new ArrayList<ChatModel>();


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserData");


        userid = FirebaseAuth.getInstance().getCurrentUser().getUid();

//        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);


        final ConversationService myConversationService =
                new ConversationService(
                        "2018-10-14",
                        getString(R.string.username),
                        getString(R.string.password)
                );

        databaseReference2=FirebaseDatabase.getInstance().getReference("UserData").child(userid).child("MainChatting");
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot2: dataSnapshot.getChildren()) {
                    ChatModel chatModel2 = dataSnapshot2.getValue(ChatModel.class);
                    list.add(chatModel2);
                    int newMsgPosition = list.size() - 1;
                    recyclerView.scrollToPosition(newMsgPosition);

                }
                adapter= new MyAdapter(MainActivity.this,list);
                recyclerView.setAdapter(adapter);
                list2=list;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        sendImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnInvisisble.setVisibility(View.GONE);


                inputText = etTypingMsg.getText().toString();



        MessageRequest request = new MessageRequest.Builder()
                                .inputText(inputText)
                                .build();

        myConversationService.message(getString(R.string.workspace), request)
                                .enqueue(new ServiceCallback<MessageResponse>() {

                                    @Override
                                    public void onResponse(MessageResponse response) {

                                        outputText = "";
                                        int length=response.getText().size();
                                        Log.i("testing", "run: "+length);
                                        if(length>1) {
                                            for (int i = 0; i < length; i++) {
                                                outputText += '\n' + response.getText().get(i).trim();
                                            }

                                        }
                                        else
                                            outputText = response.getText().get(0);
                                        if(outputText==null)
                                            outputText="I didn't Understand. Write in a proper way";



                                        AsyncTask.execute(new Runnable() {
                                            @Override
                                            public void run() {

                                                //code you want to run on the background
                                                chatkey= databaseReference.push().getKey();
                                                chatModel=new ChatModel(inputText,outputText,chatkey);
                                                databaseReference.child(userid).child("MainChatting").child(chatkey).setValue(chatModel);


                                                //the code you want to run on main thread
                                                MainActivity.this.runOnUiThread(new Runnable() {

                                                    public void run() {
                                                        if(outputText.toLowerCase().contains("You should meet with".toLowerCase())){
                                                            btnInvisisble.setText("Click here for Specialists list");
                                                            btnInvisisble.setVisibility(View.VISIBLE);
                                                            btnInvisisble.startAnimation(shake);
                                                        }else if(outputText.contains("আপনার উচিত একজন")){
                                                            btnInvisisble.setText("বিশেষজ্ঞের তালিকার জন্য এখানে ক্লিক করুন");
                                                            btnInvisisble.setVisibility(View.VISIBLE);
                                                            btnInvisisble.startAnimation(shake);
                                                        }
                                                        /*the code you want to run after the background
                                                        operation otherwise they will executed earlier and give you an error*/


                                                    }
                                                });
                                            }
                                        });




                                    }
                                    @Override
                                    public void onFailure(Exception e) {}

                                });

                etTypingMsg.setText("");
                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }



            }
        });
}

    public void GotoSpecialistsOption(View view) {
        Intent intent1 = new Intent(MainActivity.this, SpecialistsNameActivity.class);
        startActivity(intent1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent1 = new Intent(MainActivity.this, MenuSelection.class);
        startActivity(intent1);

    }
}