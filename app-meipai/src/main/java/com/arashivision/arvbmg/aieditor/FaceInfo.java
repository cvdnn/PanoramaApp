package com.arashivision.arvbmg.aieditor;

import e.a.a.a.a;

public class FaceInfo {
    public int age;
    public float faceQulitity;
    public int gender;
    public int height;
    public int left;
    public int mood;
    public float moodConfidence;
    public int top;
    public int width;

    public String toString() {
        StringBuilder a2 = a.a("FaceInfo{gender=");
        a2.append(this.gender);
        a2.append(", age=");
        a2.append(this.age);
        a2.append(", mood=");
        a2.append(this.mood);
        a2.append(", moodConfidence=");
        a2.append(this.moodConfidence);
        a2.append(", faceQulitity=");
        a2.append(this.faceQulitity);
        a2.append(", left=");
        a2.append(this.left);
        a2.append(", top=");
        a2.append(this.top);
        a2.append(", width=");
        a2.append(this.width);
        a2.append(", height=");
        a2.append(this.height);
        a2.append('}');
        return a2.toString();
    }
}
