package ast;

public abstract class CFunction extends CAst {
    public String name;
    public void updateName(String newName){
        name = newName;
    }

}
