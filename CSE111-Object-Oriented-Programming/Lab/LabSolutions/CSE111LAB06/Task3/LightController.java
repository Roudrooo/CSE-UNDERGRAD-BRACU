public class LightController {
    public String status;
    public int level;
    public LightController(){
        status="OFF";
        level=0;
    }
    public void switchLight(){
        if(status.equals("OFF")){
            status="ON";
            System.out.println("Lights are now ON.");
            level=1;
        }else{
            status="OFF";
            System.out.println("Lights are now OFF.");
            level=0;
        }
    }
    public void adjustBrightness(int a){
        if(status.equals("OFF")){
            System.out.println("Please turn on the light first!");
        }else{
            level+=a;
        if(level<0||level>10){
            System.out.println("Brightness out of range. Set between 0 to 10.");
            level-=a;
        }else{
            System.out.println("Brightness adjusted.");
        }
        }
    }
    public String resetSettings(){
        level=1;
        return "Light settings have been reset.";
    }
    public void showLightStatus(){
        System.out.println("Light status: "+status+"\nBrightness Level: "+level);
    }
}