public class RegistrazioneAudio extends Riproduzione{
    public RegistrazioneAudio(String title, int time,int volume, boolean play) {
        super(title, time,volume,play,false,0);
    }

    @Override
    protected String play() {
        if (play) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < time; i++) {
                result.append("Title:").append(" ");
                result.append(title);
                result.append("\n");
                result.append("Volume:").append(" ");
                for (int j = 0; j < volume ; j++) {
                    result.append("!").append(" ");
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

    @Override
    protected String getInfo() {
        return "Il titolo della registrazione è: " + title + ", durata: "
                + time + ", livello volume : " + volume + ", play attivo: " + play + "\n" ;
    }
}
