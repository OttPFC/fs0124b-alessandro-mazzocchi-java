public class Video extends Riproduzione{

    public Video(String title, int time,int volume, boolean play, int luminosita) {
        super(title, time,volume, play,false,luminosita);
    }

    @Override
    protected String play() {
        if (play) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < time; i++) {
                result.append("Title:").append(" ");
                result.append(title).append(" ");
                result.append("\n");
                result.append("Volume:").append(" ");
                for (int j = 0; j < volume ; j++) {
                    result.append("!").append(" ");
                }
                result.append("\n");
                result.append("Luminosità:").append(" ");
                for (int k = 0; k < luminosita; k++) {
                    result.append("*").append(" ");
                }
                result.append("\n");
                result.append("\n");
            }
            return result.toString();
        } else {
            return "Non è possibile mettere in play il tuo elemento!";
        }
    }

    @Override
    protected String show() {
        return null;
    }

    public int abbassaLuminosita(int lum){
        if(lum > luminosita){
            System.out.println("Il volume deve essere minore di quello già presente");
            return luminosita;
        }else{
            return luminosita = lum;
        }
    }
    public int alzaLuminosita(int lum){
        if(lum < luminosita){
            System.out.println("Il volume deve essere maggiore di quello già presente");
            return luminosita;
        }else{
            System.out.println("Il volume è impostato a: " + lum);
            return luminosita = lum;
        }
    }

    @Override
    protected String getInfo() {
        return "Il titolo del video è: " + title + ", durata: " + time + ", livello volume: " + volume + ", luminosita: " + luminosita + ", play attivo: " + play + "\n";

    }
}
