package com.example.ahmedassem.chattapp;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ahmedassem.chattapp.Adapter.Groupchatadapter;
import com.example.ahmedassem.chattapp.Userdata.GroupChat;
import com.example.ahmedassem.chattapp.Design.MyDividerItemDecoration;
import java.util.ArrayList;
import java.util.List;

public class groupchat extends AppCompatActivity {
    private List<GroupChat> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Groupchatadapter mAdapter;
    private TextView newgroupchat;
    private ImageView imageView;
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;
    de.hdodenhof.circleimageview.CircleImageView newchatimageview;
    String[] listItems={"AbdelSadek Nady","Mohamed Galal", "Ibrahim Nasr", "Mohamed Serag", "Abdelaziz Hassan", "Mohamed Mamdoh", "Dallah :D "};
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groupchat);
        checkedItems = new boolean[listItems.length];

        setId();

        intializeRecyclerview();

        prepareMovieData();



        newgroupchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLangDialog();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLangDialog();
            }
        });


    }

    private void prepareMovieData() {
        GroupChat movie = new GroupChat("Meesi");
        movieList.add(movie);

        movie = new GroupChat("Inesta");
        movieList.add(movie);

        movie = new GroupChat("Xavi");
        movieList.add(movie);

        movie = new GroupChat("Ronaldinho");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }


    private void setId()
    {
        /* Set Id */
        newchatimageview =findViewById(R.id.newgroupchatimageview);
        imageView=findViewById(R.id.newgroupchatimage);
        newgroupchat=findViewById(R.id.newgroupchat);
        recyclerView = findViewById(R.id.groupchatlist);
    }


    private void intializeRecyclerview()
    {
        /* Intialize RecyclerView */
        mAdapter = new Groupchatadapter(movieList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 5));
        recyclerView.setAdapter(mAdapter);

    }


    public void showChangeLangDialog()
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.newgroupchat, null);
        dialogBuilder.setView(dialogView);

        final EditText text=dialogView.findViewById(R.id.searchMultiSpinnerUnlimited);
        Button button=dialogView.findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v7.app.AlertDialog.Builder mBuilder = new android.support.v7.app.AlertDialog.Builder(groupchat.this);
                mBuilder.setTitle("Firend List");
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
//
                        if(isChecked){
                            mUserItems.add(position);
                        }else{
                            mUserItems.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < mUserItems.size(); i++) {
                            item = item + listItems[mUserItems.get(i)];
                            if (i != mUserItems.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        text.setText(item);
                    }
                });

                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setNeutralButton("Clear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            mUserItems.clear();
                            text.setText("");
                        }
                    }
                });

                android.support.v7.app.AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        newchatimageview=dialogView.findViewById(R.id.newgroupchatimageview);

        Button choosephoto=dialogView.findViewById(R.id.choose);
        choosephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
            }
        });





        dialogBuilder.setTitle("New Group Chat");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();

            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK

                    && null != data) {
                // Get the Image from data
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();

                // Set the Image in ImageView after decoding the String
                newchatimageview.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
            } else {
                Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }

}


