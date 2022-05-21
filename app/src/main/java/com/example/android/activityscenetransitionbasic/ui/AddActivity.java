package com.example.android.activityscenetransitionbasic.ui;

import static com.example.android.activityscenetransitionbasic.network.ApiClient.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.activityscenetransitionbasic.R;
import com.example.android.activityscenetransitionbasic.model.Job;
import com.example.android.activityscenetransitionbasic.model.Student;
import com.example.android.activityscenetransitionbasic.network.myapi;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddActivity extends AppCompatActivity {

    private static final String TAG="AddActivity";
   private EditText name,devJob,address,phone,marks;
      Button button ;

        String url="https://reqres.in/api/";
//       String url="https://10.0.2.2/api/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name = findViewById(R.id.username);
        devJob = findViewById(R.id.password);
//        address = findViewById(R.id.Address);
//        phone = findViewById(R.id.Phone);
//        marks = findViewById(R.id.Marks);


        //========================================
         button = findViewById(R.id.submit);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                  savedata();
             }
         });
    }

    public void savedata(){

        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myapi api =  retrofit1.create(myapi.class);
          String empName = name.getText().toString();
          String empJob = devJob.getText().toString();

       /*   String empAddress= address.getText().toString();
          String empPhone = phone.getText().toString();
          String empMarks = marks.getText().toString();*/
//
//          Student student = new Student( 1, empName, empMarks,empEmail,empPhone,empAddress);
//          Log.e(TAG,"Fatch Data: "+student);
//                Call<List<Student>> saveData=api.getsavedata(student);
        Job job = new Job(empName,empJob,"2");
        Log.e(TAG,"Data:"+job);
        Call<Job>saveData=api.getsavedata(job);

//        Student student= new model(name.getText().toString(),Email.getText().toString(),
//                Address.getText().toString(),Phone.getText().toString(),marks.getText().toString()
//                );

/*        saveData.enqueue( new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                List<Student> data = response.body();
                Log.e(TAG,"AllData : "+ data );

            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Log.i(TAG,"Error");
                Log.d("AddA",t.getMessage());
            }
        });*/
        saveData.enqueue(new Callback<Job>() {
            @Override
            public void onResponse(Call<Job> call, Response<Job> response) {
                Object data=response.body();
                Job job =(Job) data;
                Log.e(TAG,"All Data:"+data.toString());
                name.setText(job.getName()+job.getJob());
            }

            @Override
            public void onFailure(Call<Job> call, Throwable t) {
                Log.i(TAG,"Error");
                Log.d("AddA",t.getMessage());
            }
        });

    }
}
