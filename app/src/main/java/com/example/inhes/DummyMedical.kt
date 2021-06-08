package com.example.inhes

object DummyMedical {
    val dummyName = arrayOf(
        "Anemia",
        "COVID-19",
        "Diabetes"
    )
    val dummyAbout = arrayOf(
        "Anemia is the general name for a condition where the body either cannot make enough healthy red blood cells and/or has too little hemoglobin, the substance that enables red blood cells to transport oxygen around the body.",
        "COVID-19 is the disease resulting from infection by a new respiratory virus (SARS-CoV-2), first identified on December 8, 2019 in Wuhan, Hubei Province, China as the cause of a respiratory illness outbreak. The name ‘COVID-19’ was suggested by the WHO (World Health Organization), using established guidelines.",
        "Diabetes mellitus, commonly referred to as diabetes, is a condition in which the body’s blood glucose, or blood sugar, is too high. Glucose comes from the food we eat and is the body’s main source of energy. It is helped to reach the cells of the body by insulin, a hormone produced in the pancreas. Diabetes occurs when the body produces no or insufficient quantities of insulin to do this, and so glucose builds up in the blood."
    )
    val dummyCause = arrayOf(
        "Dietary deficiencies of essential vitamins and minerals, such as vitamin B12, folic acid and iron " +
                "Malabsorption of nutrients, e.g. in celiac disease, Crohn’s disease " +
                "Substantial blood loss, e.g. from heavy menstruation or inflammatory bowel disease " +
                "Bone marrow problems and leukemia " +
                "Certain chronic conditions, e.g. rheumatoid arthritis, kidney disease (anemia of chronic disease) " +
                "Certain genetic disorders, e.g. thalassemia and sickle cell disease " +
                "Certain infections, e.g. malaria " +
                "Certain medications and therapies, e.g. some types of painkillers, antibiotics, drugs for hyperthyroidism and cancer treatments " +
                "Periods where the body needs more energy than usual, such as puberty and pregnancy",
        "Coronaviruses are a large family of viruses that cause infection in a variety of animal species. Bats appear to be the reservoir of the COVID-19 virus, but the intermediate host(s) has not yet been identified. Coronaviruses can also spread between animals and humans, and in some cases, also between humans. This is rare, but in the past, has led to outbreaks (MERS-CoV and SARS).",
        "diabetes are caused by an insufficiency of insulin."
    )
    val dummyPrecaution = arrayOf(
        "While it may not be possible to prevent all types of anemia, steps can be taken to reduce the risk of developing anemia related to nutritional deficiencies. These include:\n" +
                "Eating a well-balanced diet\n" +
                "Eating fortified foods and/or taking vitamin and mineral supplements where one’s diet is restrictive, e.g. vegetarians and vegans\n" +
                "Avoiding regular consumption of tannin-containing tea or coffee with meatless meals, as this may interfere with absorption of iron from plant sources\n",
        "At present, there is no vaccine to prevent COVID-19. Avoiding exposure to the virus is the best way to prevent infection. Standard measures to prevent the spread of respiratory viruses apply",
        "Maintaining a healthy weight\n" +
                "Exercising regularly\n" +
                "Not smoking\n" +
                "Minimising alcohol intake"
    )
    val dummySymptoms = arrayOf(
        "Tiredness and lethargy\nBreathlessness\nFaintness\nHeadaches",
        "Typical signs and symptoms include fever, dry cough, fatigue, coughing up phlegm, and shortness of breath. Some cases also report sore throat, headache, muscle pain, and chills.",
        "Excessive thirst\n" +
                "A need to urinate frequently\n" +
                "Excessive hunger\n" +
                "Fatigue or tiredness\n" +
                "Blurred vision\n" +
                "Wounds that are slow to heal\n" +
                "Unexplained weight loss\n" +
                "Tingling and/or pain in the extremities"
    )

    val listData: ArrayList<MedicalDummies>
        get() {
            val list = arrayListOf<MedicalDummies>()
            for (position in dummyName.indices) {
                val dummy = MedicalDummies()
                dummy.name = dummyName[position]
                dummy.about = dummyAbout[position]
                dummy.cause = dummyCause[position]
                dummy.precaution = dummyPrecaution[position]
                dummy.symptoms = dummySymptoms[position]
                list.add(dummy)
            }
            return list
        }
}