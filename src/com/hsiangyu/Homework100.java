// https://www.facebook.com/init.kobeengineer/photos/a.1416496745064002/4073754216004895/
// https://www.facebook.com/groups/programming.tw/posts/1413989655646655/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hsiangyu;

import static com.hsiangyu.util.Output.println;
import static com.hsiangyu.util.Output.print;
import static com.hsiangyu.util.Output.printf;

import com.hsiangyu.model.Gender;
import com.hsiangyu.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author acer
 */
public class Homework100 {

    private static List<Student> getListData() {
        List<Student> resultList = new ArrayList<Student>();
        resultList.add(new Student("CatherineSimon", Gender.MALE, 10));
        resultList.add(new Student("Izabella", Gender.MALE, 20));
        resultList.add(new Student("Antwan", Gender.MALE, 58));
        resultList.add(new Student("Johann", Gender.MALE, 70));
        resultList.add(new Student("Anastasia", Gender.MALE, 82));

        resultList.add(new Student("Jon", Gender.FEMALE, 12));
        resultList.add(new Student("Vee", Gender.FEMALE, 24));
        resultList.add(new Student("Elsa", Gender.FEMALE, 64));
        resultList.add(new Student("Hobart", Gender.FEMALE, 75));
        resultList.add(new Student("Buddy", Gender.FEMALE, 86));
        return resultList;
    }

    public static void main(String[] args) {
        List<Student> dataList = getListData();
        Map<Gender, String> genderMap = new HashMap<Gender, String>();
        genderMap.put(Gender.MALE, "男性");
        genderMap.put(Gender.FEMALE, "女性");

        // 1. 給定n個學生的資料，包含姓名、性別與成績，請輸出女生最高分與男生最高分分別是誰.
        println("第 01 題");
        Optional<Student> maleStudent = dataList.stream()
                .filter((Student v) -> (v.getGender() == Gender.MALE))
                .max((Student s1, Student s2) -> (s1.getScore() - s2.getScore()));
        if (maleStudent.isPresent()) {
            Student s1 = maleStudent.get();
            printf("男生最高分 -> %s%n", s1.toString());
        }

        Optional<Student> femaleStudent = dataList.stream()
                .filter((Student v) -> (v.getGender() == Gender.FEMALE))
                .max((Student s1, Student s2) -> (s1.getScore() - s2.getScore()));
        if (femaleStudent.isPresent()) {
            Student s2 = femaleStudent.get();
            printf("女生最高分 -> %s%n", s2.toString());
        }

        // 2. 給定n個學生的資料，包含姓名、性別與成績，請輸出女生與男生的及格人數.
        println("第 02 題");
        long malePassingCount = dataList.stream()
                .filter((Student v) -> (v.getGender() == Gender.MALE))
                .filter((Student v) -> (v.getScore() >= 60))
                .count();
        printf("男生及格人數 -> %d%n", malePassingCount);

        long femalePassingCount = dataList.stream()
                .filter((Student v) -> (v.getGender() == Gender.FEMALE))
                .filter((Student v) -> (v.getScore() >= 60))
                .count();
        printf("女生及格人數 -> %d%n", femalePassingCount);

        // 3. 給定n個學生的資料，包含姓名、性別與成績，請輸出名字最長與最短的學生性別.
        println("第 03 題");
        Optional<Student> longName = dataList.stream()
                .max((Student s1, Student s2) -> (s1.getName().length() - s2.getName().length()));
        if (longName.isPresent()) {
            printf("名字最長的學生性別是 -> %s%n", genderMap.get(longName.get().getGender()));
        }

        Optional<Student> shortName = dataList.stream()
                .min((Student s1, Student s2) -> (s1.getName().length() - s2.getName().length()));
        if (shortName.isPresent()) {
            printf("名字最短的學生性別是 -> %s%n", genderMap.get(shortName.get().getGender()));
        }

        // 4. 給定n個學生的資料，包含姓名、性別與成績，請將學生按成績高低排序並輸出完整資料.
        println("第 04 題");
        List<Student> sortList = dataList.stream()
                .sorted((Student s1, Student s2) -> ((-1) * (s1.getScore() - s2.getScore())))
                .collect(Collectors.toList());
        for (int i = 0; i < sortList.size(); ++i) {
            println(sortList.get(i).toString());
        }

        // 5. 給定n個學生的資料，包含姓名、性別與成績，請將學生按女生優先排序，.
        // 性別相同時按成績高低排序並輸出完整資料.
        println("第 05 題");
        Map<Gender, Integer> genOrder = new HashMap<Gender, Integer>();
        genOrder.put(Gender.FEMALE, 1); // 女生
        genOrder.put(Gender.MALE, 2); // 男生
        List<Student> sortList2 = dataList.stream()
                .sorted((Student s1, Student s2) -> ((-1) * (s1.getScore() - s2.getScore())))
                .sorted((Student s1, Student s2) -> (genOrder.get(s1.getGender()) - genOrder.get(s2.getGender())))
                .collect(Collectors.toList());
        for (int i = 0; i < sortList2.size(); ++i) {
            println(sortList2.get(i).toString());
        }

        // 6. 給定n個學生的資料，包含姓名、性別與成績，請輸出女生最低分與男生最低分分別是誰。.
        println("第 06 題");
        Optional<Student> minScore1 = dataList.stream()
                .filter((Student v) -> (v.getGender() == Gender.FEMALE))
                .min((Student s1, Student s2) -> (s1.getScore() - s2.getScore()));
        if (minScore1.isPresent()) {
            printf("女生最低分者是 -> %s%n", minScore1.get().getName());
        }

        Optional<Student> minScore2 = dataList.stream()
                .filter((Student v) -> (v.getGender() == Gender.MALE))
                .min((Student s1, Student s2) -> (s1.getScore() - s2.getScore()));
        if (minScore2.isPresent()) {
            printf("男生最低分者是 -> %s%n", minScore2.get().getName());
        }

        // 7. 給定n個學生的資料，包含姓名、性別與成績，請輸出女生與男生的不及格人數.
        println("第 07 題");
        long maleNotPassingCount = dataList.stream()
                .filter((Student v) -> (v.getGender() == Gender.MALE))
                .filter((Student v) -> (v.getScore() < 60))
                .count();
        printf("男生不及格人數 -> %d%n", maleNotPassingCount);
        long femaleNotPassingCount = dataList.stream()
                .filter((Student v) -> (v.getGender() == Gender.FEMALE))
                .filter((Student v) -> (v.getScore() < 60))
                .count();
        printf("女生不及格人數 -> %d%n", femaleNotPassingCount);

        // 8. 給定n個學生的資料，包含姓名、性別與成績，請輸出女生與男生的不及格人數.
        println("第 08 題");
        printf("男生不及格人數 -> %d%n", maleNotPassingCount);
        printf("女生不及格人數 -> %d%n", femaleNotPassingCount);

        // 9. 給定n個學生的資料，包含姓名、性別與成績，將學生按姓名字典順序排序並輸出資料.
        println("第 09 題");
        List<Student> sortList3 = dataList.stream()
                .sorted((Student s1, Student s2) -> (s1.getName().compareTo(s2.getName())))
                .collect(Collectors.toList());
        for (int i = 0; i < sortList3.size(); ++i) {
            println(sortList3.get(i).toString());
        }

        // 10. 給定n個學生的資料，包含姓名、性別與成績，請將學生按姓名長度由短到長優先排序，長度相同時按照成績由低到高排序並輸出完整資料.
        println("第 10 題");
        List<Student> sortList4 = dataList.stream()
                .sorted((Student s1, Student s2) -> (s1.getScore() - s2.getScore()))
                .sorted((Student s1, Student s2) -> (s1.getName().length() - s2.getName().length()))
                .collect(Collectors.toList());
        for (int i = 0; i < sortList4.size(); ++i) {
            println(sortList4.get(i).toString());
        }
    }
}
