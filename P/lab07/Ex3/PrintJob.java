public class PrintJob implements Runnable {
    private Document doc;
    private static int nextID = 0;
    private int id;

    public PrintJob(Document doc) {
        this.doc = doc;
        this.id = nextID;
        nextID++;
    }

    public int getId() {
        return this.id;
    }

    public Document getDocument() {
        return this.doc;
    }

    public String toString() {
        String fullText = doc.readFile();
        return "Job " + this.id + ": \"" + fullText.substring(0, 20) + "...\"";
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished " + this.toString());
    }
}
