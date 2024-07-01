import java.util.ArrayList;

class MutableString {
    private ArrayList<Character> string;

    public MutableString(String string) {
        this.string = new ArrayList<Character>();
        for (int i = 0; i < string.length(); i++) {
            this.string.add(string.charAt(i));
        }
    }

    public MutableString(ArrayList<Character> string) {
        this.string = string;
    }

    public String getString() {
        String str = new String();
        for (int i = 0; i < this.string.size(); i++) {
            str += this.string.get(i);
        }
        return str;
    }

    public void setString(String string){
        for(int i = 0; i < string.length(); i++){
            this.string.set(i, string.charAt(i));
        }
    }

    public void append(char c) {
        this.string.add(c);
    }

    public MutableString substring(int start) {
        ArrayList<Character> newString = new ArrayList<Character>(this.string.subList(start, this.string.size()));
        return new MutableString(newString);
    }

    public void concat(char[] cArr) {
        for (int i = 0; i < cArr.length; i++) {
            this.string.add(cArr[i]);
        }
    }

    public void concat(MutableString obj) {
        for (int i = 0; i < obj.length(); i++) {
            this.string.add(obj.string.get(i));
        }
    }

    public int length() {
        return this.string.size();
    }
}

class Main {
    public static void main(String[] args) {
        MutableString str = new MutableString("Hello");
        System.out.println(str.getString()); // Hello
        str.append(' ');
        str.append('W');
        str.append('o');
        str.append('r');
        str.append('l');
        str.append('d');
        System.out.println(str.getString()); // Hello World
        System.out.println(str.length()); // 11
        MutableString str2 = str.substring(6); 
        System.out.println(str2.getString()); // World
        
        char[] cArr = {'!', '!', '!'};
        str2.concat(cArr);
        System.out.println(str2.getString()); // World!!!
        str.concat(str2);
        System.out.println(str.getString()); // Hello WorldWorld!!!
    }
}