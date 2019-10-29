package sample;

public class AudioPlayer extends Product implements MultimediaControl {

    private String audioSpecification;
    private String mediaType;

    public AudioPlayer(String name, String mediaType, String audioSpecification) {
        super(name);
        this.mediaType = mediaType;
    }


    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setName(String parameter) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setManufacturer(String parameter) {

    }

    @Override
    public String getManufacturer() {
        return null;
    }
    @Override
    public String toString(){
        return super.toString() +
                "\nAudio Spec: " + audioSpecification +
                "\nMedia Type:" + mediaType;

    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void previous() {

    }

    @Override
    public void next() {

    }
}
