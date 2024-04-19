public abstract class Riproduzione {

    protected String title;
    protected int time;
    protected int volume;
    protected int luminosita;
    protected boolean play;
    protected boolean show;
    public Riproduzione(String title, int time,int volume, boolean play,boolean show, int luminosita) {
        this.title = title;
        this.time = time;
        this.volume = volume;
        this.play = play;
        this.show = show;
        this.luminosita = luminosita;
    }

    protected abstract String play();
    protected abstract String show();
    protected abstract String getInfo();

    public int abbassaVolume(int vol){
        if(vol > volume){
            System.out.println("Il volume deve essere minore di quello già presente");
            return volume;
        }else{
            return volume = vol;
        }
    }
    public int alzaVolume(int vol){
        if(vol < volume){
            System.out.println("Il volume deve essere maggiore di quello già presente");
            return volume;
        }else{
            return volume = vol;
        }
    }



}
