package com.example.android.activityscenetransitionbasic.model;

public class Student {

//    int id,userId;
//    String title,body;
//
//    public model(int id,int userId,String title,String body) {
//        this.id = id;
//        this.userId=userId;
//        this.title=title;
//        this.body=body;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }

        int id;
    String name,marks,email,phone,address;

    public Student(int id , String name, String marks, String email, String phone, String address) {
        this.id = id;
        this.name=name;
        this.marks=marks;
        this.email=email;
        this.phone=phone;
        this.address=address;
    }

    public Student(String toString, String name, String marks, String email, String phone) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks(){
        return marks;
    }
    public void setMarks(String marks){
        this.marks= marks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks='" + marks + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
