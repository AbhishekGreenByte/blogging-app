package app.blogging.exceptions;



public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String resourceField;
    Long fieldValue;

    public ResourceNotFoundException(String resourceName, String resourceField, Long fieldValue) {
        super(resourceName+ " not found with "+resourceField+" : "+fieldValue);
        this.resourceName = resourceName;
        this.resourceField = resourceField;
        this.fieldValue = fieldValue;
    }
}
