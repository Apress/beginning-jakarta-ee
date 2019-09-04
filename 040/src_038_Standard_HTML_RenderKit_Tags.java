import javax.servlet.http.Part;
...
private Part upload; // + getter/setter
...
public void theSubmit() {
  try (InputStream input = upload.getInputStream()) {
    String n = upload.getSubmittedFileName();
    String path = "..."; // where to put the file
    String name = "..."; // file name
    Files.copy(input, new File(path + File.separator + 
          name).toPath());
  }catch(Exception e) {
    // Handle exception...
    // Quick and dirty, don't use in production:
    e.printStackTrace(System.err);
  }
...
}
