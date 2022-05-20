package src.models.Hiring;

public class JobApplication {
    public  Integer id;
    public  Integer userId;
    public  Integer jobPostId;
    public  String paymentMethod;
    public  Integer locationId;
    public String referenceName;
    public  String referencePhone;
    public  String resume;
    public  String certificate;
    public  String status;
    public JobApplication(int id,int jobPostId,int userId,int locationId,String referenceName, String referencePhone,String resume,String certificate,String status ){
        this.id=id;
        this.jobPostId=jobPostId;
        this.userId=userId;
        this.locationId=locationId;
        this.referenceName=referenceName;
        this.referencePhone=referencePhone;
        this.resume=resume;
        this.certificate=certificate;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JobApplication() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public  Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(Integer jobPostId) {
        this.jobPostId = jobPostId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public  String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public  String getReferencePhone() {
        return referencePhone;
    }

    public void setReferencePhone(String referencePhone) {
        this.referencePhone = referencePhone;
    }

    public  String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public  String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("-----------JOB APPLICATION INFORMATION");
        sb.append("ID: "+getId());
        sb.append("Job post id "+getJobPostId());
        sb.append("user id" +getUserId());
        sb.append("locationId "+getLocationId());
        sb.append("payment method "+getPaymentMethod());
        sb.append("referenceName "+getReferenceName());
        sb.append("reference phone "+getReferencePhone());
        sb.append("resume "+getResume());
        sb.append("certificate "+getCertificate());
        return  sb.toString();
    }
}
