package bean;

import java.util.Map;
public class TestListSubject {
   private int entYear;
   private String studentNo;
   private String studentName;
   private String classNum;
   private Map<Integer, Integer> points;
   // コンストラクタ
   public TestListSubject() {}
   // entYearの取得
   public int getEntYear() {
       return entYear;
   }
   // entYearの設定
   public void setEntYear(int entYear) {
       this.entYear = entYear;
   }
   // studentNoの取得
   public String getStudentNo() {
       return studentNo;
   }
   // studentNoの設定
   public void setStudentNo(String studentNo) {
       this.studentNo = studentNo;
   }
   // studentNameの取得
   public String getStudentName() {
       return studentName;
   }
   // studentNameの設定
   public void setStudentName(String studentName) {
       this.studentName = studentName;
   }
   // classNumの取得
   public String getClassNum() {
       return classNum;
   }
   // classNumの設定
   public void setClassNum(String classNum) {
       this.classNum = classNum;
   }
   // pointsの取得
   public Map<Integer, Integer> getPoints() {
       return points;
   }
   // pointsの設定
   public void setPoints(Map<Integer, Integer> points) {
       this.points = points;
   }
   // 特定のキーのポイント取得
   public int getPoint(int key) {
       return points.get(key);
   }
   // 特定のキーのポイント設定
   public void putPoint(int key, int value) {
       points.put(key, value);
   }
}