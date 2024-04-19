public class Immagine extends Riproduzione{

    public Immagine(String title, int time, boolean show, int luminosita) {
        super(title, time,0,false,show,luminosita);

    }

    @Override
    protected String play() {
        return null;
    }

    @Override
    protected String show(){
        if (show) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < time; i++) {
                result.append("Title:").append(" ");
                result.append(title);
                result.append("\n");
                result.append("Luminosità:").append(" ");
                for (int j = 0; j < luminosita ; j++) {
                    result.append("*").append(" ");
                }
                result.append("\n");
                result.append("\n");
            }
            return result.toString();
        } else {
            return "Non è possibile mettere visulizzare il tuo elemento!";
        }
    }

    @Override
    protected String getInfo() {
        return "Il titolo dell'immagine è: " + title + ", durata: " + time + ", livello volume: " +  luminosita + ", show attivo: " + show + "\n";

    }



}
