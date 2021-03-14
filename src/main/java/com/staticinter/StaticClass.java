package com.staticinter;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-4-30 22:38:40
 */
public class StaticClass {
    private String fatherName;
    private String fatherSex;
    private Integer fatherAge;

    public StaticClass() {
    }

    public StaticClass(String fatherName, String fatherSex, Integer fatherAge) {
        this.fatherName = fatherName;
        this.fatherSex = fatherSex;
        this.fatherAge = fatherAge;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherSex() {
        return fatherSex;
    }

    public void setFatherSex(String fatherSex) {
        this.fatherSex = fatherSex;
    }

    public Integer getFatherAge() {
        return fatherAge;
    }

    public void setFatherAge(Integer fatherAge) {
        this.fatherAge = fatherAge;
    }

    public double earnMoney(){
        return (Math.random())*10000;
    }

    @Override
    public String toString() {
        return "StaticClass{" +
                "fatherName='" + fatherName + '\'' +
                ", fatherSex='" + fatherSex + '\'' +
                ", fatherAge=" + fatherAge +
                '}';
    }

    public static StaticInteriorClass staticInteriorClass = null;
    //外部类调用这个方法就返回一个内部类实例
    public static StaticInteriorClass getStaticInteriorClass(){
        if(staticInteriorClass==null){
            staticInteriorClass = new StaticInteriorClass();
        }
        return staticInteriorClass;
    }

    public static class StaticInteriorClass{
        private String SonName;
        private String SonSex;
        private Integer SonAge;

        //私有化构造器
        private StaticInteriorClass() {
        }

        public StaticInteriorClass(String sonName, String sonSex, Integer sonAge) {
            SonName = sonName;
            SonSex = sonSex;
            SonAge = sonAge;
        }

        public String getSonName() {
            return SonName;
        }

        public void setSonName(String sonName) {
            SonName = sonName;
        }

        public String getSonSex() {
            return SonSex;
        }

        public void setSonSex(String sonSex) {
            SonSex = sonSex;
        }

        public Integer getSonAge() {
            return SonAge;
        }

        public void setSonAge(Integer sonAge) {
            SonAge = sonAge;
        }

        public void consumeMoney(Integer money){
            System.out.println("把钱花完");
        }

        @Override
        public String toString() {
            return "StaticInteriorClass{" +
                    "SonName='" + SonName + '\'' +
                    ", SonSex='" + SonSex + '\'' +
                    ", SonAge=" + SonAge +
                    '}';
        }
    }
}
