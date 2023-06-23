// https://www.facebook.com/init.kobeengineer/photos/a.1416496745064002/4073754216004895/
// https://www.facebook.com/groups/programming.tw/posts/1413989655646655/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hsiangyu.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author acer
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name = ""; // 姓名.
    private Gender gender = Gender.MALE; // 性別.
    private int score = 0;// 成績.
    Map<Gender, String> genderMap = new HashMap<Gender, String>();

    public Student(String _name, Gender _gender, int _score) {
        this.name = _name;
        this.gender = _gender;
        this.score = _score;
        genderMap.put(Gender.MALE, "男");
        genderMap.put(Gender.FEMALE, "女");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("姓名：%s", this.getName()));
        sb.append(String.format(", 性別：%s", this.genderMap.get(this.getGender())));
        sb.append(String.format(", 成績：%d", this.getScore()));
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.gender);
        hash = 59 * hash + this.score;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.score != other.score) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return (this.gender == other.gender);
    }

}
