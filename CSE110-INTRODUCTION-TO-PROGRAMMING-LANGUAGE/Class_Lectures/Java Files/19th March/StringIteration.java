class StringIteration {
    public static void main(String[] args) {
        String str = new String("Hello");
        for (int i = 0; i < str.length(); i++){
            System.out.print(i+" ");
            System.out.println(str.charAt(i));        
    }
  }
}
