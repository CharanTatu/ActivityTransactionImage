package com.example.android.activityscenetransitionbasic.ui;

import static com.example.android.activityscenetransitionbasic.network.ApiClient.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.activityscenetransitionbasic.R;
import com.example.android.activityscenetransitionbasic.model.Student;
import com.example.android.activityscenetransitionbasic.network.myapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataActivity extends AppCompatActivity {

    private static final String TAG="DataActivity";
    public static final String data_emp= "detail:_id";
     private TextView textView;
     RecyclerView recyclerView;
     private  TextView datas,ID,Names,Email,Address,Phone;

//     String url= "http://10.0.2.2:8080/";//"http://192.168.222.92:8080/";
//String url="https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);
        textView = findViewById(R.id.text_title);
       datas = findViewById(R.id.last_data);

     /*   ID = findViewById(R.id.id);
        Names = findViewById(R.id.names);
        Email = findViewById(R.id.email);
        Address = findViewById(R.id.address);
        Phone = findViewById(R.id.mobile);*/

         myapi api = retrofit.create(myapi.class);

        Call<List<Student>>call=api.getmodels();



        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                List<Student> data=response.body();
                recyclerView = findViewById(R.id.recycle);
                 for (int i=0; i<data.size();i++)
                 {
                  datas.append("\n Id:  "+data.get(i).getId()+"\n Name:   "+data.get(i).getName()+
                            "\n Email:   "+data.get(i).getEmail()+"\n Address:   "+data.get(i).getAddress()+
                            "\n Mobile:   "+data.get(i).getPhone()+"\n "
                    );
//                     datas.append("Get Data:"+data.get(i).getId()+"\n Title:"+data.get(i).getTitle());
                 }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Log.i(TAG,"Error");
            }
        });

         Button button = findViewById(R.id.add_data);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(DataActivity.this,AddActivity.class);
                 startActivity(intent);
             }
         });

    }


}
