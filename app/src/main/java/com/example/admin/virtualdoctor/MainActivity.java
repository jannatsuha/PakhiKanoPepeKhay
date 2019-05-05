package com.example.admin.virtualdoctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
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
import java.util.Collections;

import static kotlin.text.Typography.quote;

public class MainActivity extends AppCompatActivity {
    EditText etTypingMsg;
    ImageView sendImg;
    String inputText;
    String outputText;
    ChatModel chatModel;
    Button btnInvisisble;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    UserData userData;
    String userid;
    DatabaseReference databaseReference,databaseReference2;
    FirebaseDatabase firebaseDatabase;
    RecyclerView recyclerView;
    ArrayList<ChatModel>list;
    static ArrayList<ChatModel>list2;
    MyAdapter adapter,adapter2;
    private FirebaseDatabase fdb;
    static boolean calledAlready = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fdb= DataBaseUtil.getDatabase();
//        if (!calledAlready)
//        {
//            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//            calledAlready = true;
//        }

        etTypingMsg=findViewById(R.id.etTypeMsg);
        sendImg=findViewById(R.id.sendImg);
        recyclerView=findViewById(R.id.myRecyclerview);
        btnInvisisble=findViewById(R.id.invisibleButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<ChatModel>();
        list2=new ArrayList<ChatModel>();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserData");

        //Toast.makeText(this, "size"+list2.size(), Toast.LENGTH_SHORT).show();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){

                    UserData userData =data.getValue(UserData.class);
                    userid= userData.getUserID();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Oppss...Something Is Wrong!!", Toast.LENGTH_SHORT).show();
            }
            });


        final ConversationService myConversationService =
                new ConversationService(
                        "2017-05-26",
                        getString(R.string.username),
                        getString(R.string.password)
                );

        sendImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(MainActivity.this, "working", Toast.LENGTH_SHORT).show();
                inputText = etTypingMsg.getText().toString();



        MessageRequest request = new MessageRequest.Builder()
                                .inputText(inputText)
                                .build();

        myConversationService.message(getString(R.string.workspace), request)
                                .enqueue(new ServiceCallback<MessageResponse>() {
                                    @Override
                                    public void onResponse(MessageResponse response) {

                                        //  final String outputText = response.getText().get(0);
                                        outputText = "";
                                        int length=response.getText().size();
                                        Log.i("testing", "run: "+length);
                                        if(length>1) {
                                            for (int i = 0; i < length; i++) {
                                                outputText += '\n' + response.getText().get(i).trim();
                                            }
                                            if(outputText == "You should meet with a Asthma Specialist. Please go to Asthma Specialist list option , select one and get appointment by phone call."){
                                                btnInvisisble.setVisibility(View.VISIBLE);
                                            }
                                            ///Toast.makeText(MainActivity.this, outputText, Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                            outputText = response.getText().get(0);

                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                String chatkey= databaseReference.push().getKey();
                                                chatModel=new ChatModel(inputText,outputText,chatkey);
                                                databaseReference.child(userid).child("MainChatting").child(chatkey).setValue(chatModel);
                                            }
                                        });
                                    }
                                    @Override
                                    public void onFailure(Exception e) {}
                                });

                etTypingMsg.setText("");
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


            }
        });
}

}