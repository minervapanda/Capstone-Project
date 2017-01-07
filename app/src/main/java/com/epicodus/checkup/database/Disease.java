package com.epicodus.checkup.database;


public class Disease {
    private String diseaseName;
    private String diseaseSymptoms;
    private String diseaseOverview;
    private String diseaseExpectations;
    private String diseaseRiskFactors;
    private String diseaseTreatment;
    private String diseaseSelfCare;
    private String diseaseMadeWorseBy;

    //diseases is an array of Diseases
    public static final Disease[] diseases = {
            new Disease("ACL Injury",
                        "Knee pain, swelling, tenderness, a loud popping sound at the time of injury, a feeling that your knee is not stable",
                    "An ACL injury happens when you tear or overstretch the anterior collateral ligament on the inside of your knee. You can have a partial tear or a full tear. The ACL is most often injured during sports or other activities that cause you to make sudden stops and changes in direction. If you have an ACL injury, you may hear a loud popping sound or have severe pain or swelling in the knee. It also may feel like your knee is unstable. You may need surgery to reconstruct the ACL.",
                    "You may find it difficult to walk or put weight on your knee after an ACL injury. The symptoms usually get worse for several hours after your injury. If you have a mild strain, the ACL may heal on its own with physical therapy. If you have a torn ACL, your doctor may recommend surgery to rebuild the ACL. It can't be sewn back together, so it is replaced with part of a tendon from another part of your leg.",
                    "Being female; playing a sport that puts pressure on your knee or requires sudden changes of direction such as basketball, soccer, football, tennis, or skiing",
                    "Treatment for ACL injury may include: \n" +
                            "\n" +
                            "Anti-inflammatory medications \n" +
                            "Physical therapy \n" +
                            "Surgery\n",
                    "ACL injuries need treatment from a doctor. But you can help ease the symptoms of an ACL injury at home by: \n" +
                            "\n"+
                            "Using crutches while your knee heals \n" +
                            "Putting ice packs wrapped in a thin towel on your knee for about 20 minutes every few hours \n" +
                            "Elevating your knee \n" +
                            "Taking over-the-counter pain relivers such as ibuprofen(Advil, Motrin)",
                    "Putting weight on the knee, doing any type of activity"),

            new Disease("Anemia", "b", "c", "d", "e", "f", "g", "h"),
            new Disease("Anthrax", "b", "c", "d", "e", "f", "g", "h"),
            new Disease("Asthma", "b", "c", "d", "e", "f", "g", "h"),
            new Disease("Autism", "b", "c", "d", "e", "f", "g", "h"),
            new Disease("Black eye", "b", "c", "d", "e", "f", "g", "h"),
            new Disease("Brain injury", "b", "c", "d", "e", "f", "g", "h"),
            new Disease("Cholera", "b", "c", "d", "e", "f", "g", "h"),
            new Disease("Cold exposure", "b", "c", "d", "e", "f", "g", "h"),
            new Disease("Common cold", "b", "c", "d", "e", "f", "g", "h"),
            new Disease("Dengue fever", "b", "c", "d", "e", "f", "g", "h"),
    };

    //Each Disease has a name, symptoms, overview, expectations, riskfactors, treatment, selfcare and madeworseby
    private Disease(String diseaseName, String diseaseSymptoms, String diseaseOverview, String diseaseExpectations, String diseaseRiskFactors, String diseaseTreatment, String diseaseSelfCare, String diseaseMadeWorseBy){
        this.diseaseName = diseaseName;
        this.diseaseSymptoms = diseaseSymptoms;
        this.diseaseOverview = diseaseOverview;
        this.diseaseExpectations = diseaseExpectations;
        this.diseaseRiskFactors = diseaseRiskFactors;
        this.diseaseTreatment = diseaseTreatment;
        this.diseaseSelfCare = diseaseSelfCare;
        this.diseaseMadeWorseBy = diseaseMadeWorseBy;
    }

    public String getDiseaseName(){
        return diseaseName;
    }

    public String getDiseaseSymptoms(){
        return diseaseSymptoms;
    }

    public String getDiseaseOverview(){
        return diseaseOverview;
    }

    public String getDiseaseExpectations(){
        return diseaseExpectations;
    }

    public String getDiseaseRiskFactors(){
        return diseaseRiskFactors;
    }

    public String getDiseaseTreatment(){
        return diseaseTreatment;
    }

    public String getDiseaseSelfCare(){
        return diseaseSelfCare;
    }

    public String getDiseaseMadeWorseBy(){
        return diseaseMadeWorseBy;
    }

    public String toString(){
        return this.diseaseName;
    }
}
