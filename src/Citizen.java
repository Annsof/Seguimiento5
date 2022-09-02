public class Citizen {
private String id;
private String fullName;
private String birthDate;
private String cityOfBirth;

private Citizen right;
private Citizen left;

    public Citizen(String id, String fullName, String birthDate, String cityOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.cityOfBirth = cityOfBirth;
    }

    public Citizen getRight() {
        return right;
    }

    public void setRight(Citizen right) {
        this.right = right;
    }

    public Citizen getLeft() {
        return left;
    }

    public void setLeft(Citizen left) {
        this.left = left;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    @Override
    public String toString(){
        return "***************************\n" +
                "Name: "+fullName+"\n" +
                "Birth date: "+birthDate+"\n" +
                "ID: "+id+"\n" +
                "Birth City: "+cityOfBirth+"\n" +
                "***************************\n";
    }
}
