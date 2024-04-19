public abstract class Riproduzione {

    protected String title;
    protected int time;
    protected int volume;
    protected int luminosita;
    protected boolean play;
    protected boolean show;
    //dichiaro i costruttori per le classi che andrò ad utilizzare sfruttando l'overloading
    public Riproduzione(String title, int time,int volume, boolean play) {
        this.title = title;
        this.time = time;
        this.volume = volume;
        this.play = play;
    }
    public Riproduzione(String title, int time,int volume, boolean play, int luminosita) {
        this.title = title;
        this.time = time;
        this.volume = volume;
        this.play = play;
        this.luminosita = luminosita;
    }
    public Riproduzione(String title, int time, boolean show, int luminosita) {
        this.title = title;
        this.time = time;
        this.show = show;
        this.luminosita = luminosita;
    }
    //rendo protected i metodi da far utilizzare solo ai figli
    //poi con abstract faccio in modo di implementare i metodi nelle classi concrete
    //per poi fare un override e personalizzare il metodo.
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
