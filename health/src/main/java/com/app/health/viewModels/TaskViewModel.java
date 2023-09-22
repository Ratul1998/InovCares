package com.app.health.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.health.model.AuthRequestModel;
import com.app.health.model.AuthResponse;
import com.app.health.model.MentalQuestionModel;
import com.app.health.model.ReportRequestModel;
import com.app.health.model.ReportResponse;
import com.app.health.model.SocialQuestionModel;
import com.app.health.service.ApiService;
import com.app.health.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TaskViewModel extends ViewModel {


    private static final Retrofit retrofit = RetrofitInstance.getRetrofitInstance();

    private static final String TAG = TaskViewModel.class.getSimpleName();

    private String accessToken;

    public LiveData<Boolean> getLoading(){
        return loading;
    }
    public LiveData<String> getReportSuccess(){
        return reportSuccess;
    }

    ApiService apiService = retrofit.create(ApiService.class);

    private final MutableLiveData<Boolean> loading = new MutableLiveData<>(true);
    private final MutableLiveData<String> reportSuccess = new MutableLiveData<>("");

    public  final  List<SocialQuestionModel> socialQuestions = new ArrayList<>();

    public final List<MentalQuestionModel> mentalQuestions = new ArrayList<>();

    public final List<MentalQuestionModel> selfHealthQuestions = new ArrayList<>();

    public  int bodyWeightInteger = 50;
    public  int bodyWeightDecimal = 0;
    public int activityLevel = 0;

    public void generateAccessToken() {

        Call<AuthResponse> call = apiService.generateAuthToken(new AuthRequestModel());


        call.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {

                accessToken = "Bearer " + response.body().getData().getAccessToken();

                loading.postValue(false);

            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {

            }
        });

    }

    public void sendReportData() {


        loading.setValue(true);

        double bodyWeight = bodyWeightInteger + (0.1) * bodyWeightDecimal;


        Call<ReportResponse> call = apiService.generateReport(new ReportRequestModel("2","650741036de2407819f14961",activityLevel, 907353000000L,"male",168,bodyWeight,34,29,selfHealthQuestions),accessToken);


        call.enqueue(new Callback<ReportResponse>() {
            @Override
            public void onResponse(Call<ReportResponse> call, Response<ReportResponse> response) {

                loading.postValue(false);

                if(response.code() == 200){
                    reportSuccess.postValue(response.body().getMessage());
                }
                else{
                    reportSuccess.postValue(response.message());
                }


            }

            @Override
            public void onFailure(Call<ReportResponse> call, Throwable t) {

                reportSuccess.postValue(t.toString());

            }
        });


    }

    public void setSocialActivityQuestions() {

        if(!socialQuestions.isEmpty()) return;

        socialQuestions.add(new SocialQuestionModel("HOUSING","Are you worried or concerned that in the next two months you may not have stable housing that you own, rent, or stay in as a part of a household?",new ArrayList<String>() {
            {
                add("Yes");
                add("No");
            }
        },new ArrayList<String>(),false));
        socialQuestions.add(new SocialQuestionModel("HOUSING","Think about the place you live. Do you have problems with any of the following? (check all that apply)",new ArrayList<String>() {
            {
                add("Bug infestation");
                add("Mold");
                add("Lead paint or pipes");
                add("Inadequate heat");
                add("Oven or stove not working");
                add("No or not working smoke detectors");
                add("Water Leaks");
                add("None of the above");
            }
        },new ArrayList<String>(),true));
        socialQuestions.add(new SocialQuestionModel("FOOD","Within the past 12 months, you worried that your food would run out before you got money to buy more.",new ArrayList<String>() {
            {
                add("Often true");
                add("Sometimes true");
                add("Never true");
            }
        },new ArrayList<String>(),false));

        socialQuestions.add(new SocialQuestionModel("FOOD","Within the past 12 months, the food you bought just didn’t last and you didn’t have money to get more.",new ArrayList<String>() {
            {
                add("Often true");
                add("Sometimes true");
                add("Never true");
            }
        },new ArrayList<String>(),false));

        socialQuestions.add(new SocialQuestionModel("TRANSPORTATION","Do you put off or neglect going to the doctor because of distance or transportation?",new ArrayList<String>() {
            {
                add("Yes");
                add("No");
            }
        },new ArrayList<String>(),false));


        socialQuestions.add(new SocialQuestionModel("UTILITIES","In the past 12 months has the electric, gas, oil, or water company threatened to shut off services in your home?",new ArrayList<String>() {
            {
                add("Yes");
                add("No");
                add("Already shut off");
            }
        },new ArrayList<String>(),false));

        socialQuestions.add(new SocialQuestionModel("CHILD CARE","Do problems getting child care make it difficult for you to work or study?",new ArrayList<String>() {
            {
                add("Yes");
                add("No");
            }
        },new ArrayList<String>(),false));

        socialQuestions.add(new SocialQuestionModel("EMPLOYMENT","Do you have a job?",new ArrayList<String>() {
            {
                add("Yes");
                add("No");
            }
        },new ArrayList<String>(),false));

        socialQuestions.add(new SocialQuestionModel("EDUCATION","Do you have a high school degree?",new ArrayList<String>() {
            {
                add("Yes");
                add("No");
            }
        },new ArrayList<String>(),false));


        socialQuestions.add(new SocialQuestionModel("FINANCES","How often does this describe you? I don’t have enough money to pay my bills :",new ArrayList<String>() {
            {
                add("Never");
                add("Rarely");
                add("Sometimes");
                add("Fairly often");
                add("Frequently");
            }
        },new ArrayList<String>(),false));



        socialQuestions.add(new SocialQuestionModel("PERSONAL SAFETY","How often does anyone, including family, physically hurt you?",new ArrayList<String>() {
            {
                add("Never");
                add("Rarely");
                add("Sometimes");
                add("Fairly often");
                add("Frequently");
            }
        },new ArrayList<String>(),false));

        socialQuestions.add(new SocialQuestionModel("PERSONAL SAFETY","How often does anyone, including family, insult or talk down to you?",new ArrayList<String>() {
            {
                add("Never");
                add("Rarely");
                add("Sometimes");
                add("Fairly often");
                add("Frequently");
            }
        },new ArrayList<String>(),false));

        socialQuestions.add(new SocialQuestionModel("PERSONAL SAFETY","How often does anyone, including family, threaten you with harm?",new ArrayList<String>() {
            {
                add("Never");
                add("Rarely");
                add("Sometimes");
                add("Fairly often");
                add("Frequently");
            }
        },new ArrayList<String>(),false));


        socialQuestions.add(new SocialQuestionModel("PERSONAL SAFETY","How often does anyone, including family, scream or curse at you?",new ArrayList<String>() {
            {
                add("Never");
                add("Rarely");
                add("Sometimes");
                add("Fairly often");
                add("Frequently");
            }
        },new ArrayList<String>(),false));

        socialQuestions.add(new SocialQuestionModel("ASSISTANCE","Would you like help with any of these needs?",new ArrayList<String>() {
            {
                add("Yes");
                add("No");
            }
        },new ArrayList<String>(),false));

    }

    public void setMentalQuestions() {

        if(!mentalQuestions.isEmpty()) return;

        mentalQuestions.add(new MentalQuestionModel("I found it hard to wind down","-1"));
        mentalQuestions.add(new MentalQuestionModel("I was aware of dryness of my mouth ","-1"));
        mentalQuestions.add(new MentalQuestionModel("I could’t seem to experience any positive feeling at all","-1"));
        mentalQuestions.add(new MentalQuestionModel("I experienced breathing difficulty (e.g. excessively rapid breathing, breathlessness in the absence of physical exertion)","-1"));
        mentalQuestions.add(new MentalQuestionModel("I just couldn't seem to get going","-1"));
        mentalQuestions.add(new MentalQuestionModel("I tended to over-react to situations","-1"));
        mentalQuestions.add(new MentalQuestionModel("I had a feeling of shakiness (e.g. legs going to give way)","-1"));
        mentalQuestions.add(new MentalQuestionModel("I found it difficult to relax","-1"));
        mentalQuestions.add(new MentalQuestionModel("I found myself in situations that made me so anxious I was most relieved when they ended","-1"));
        mentalQuestions.add(new MentalQuestionModel("I found myself getting upset rather easily","-1"));
        mentalQuestions.add(new MentalQuestionModel("I felt that I was using a lot of nervous energy","-1"));
        mentalQuestions.add(new MentalQuestionModel("I felt sad and depressed","-1"));
        mentalQuestions.add(new MentalQuestionModel("I found myself getting impatient when I was delayed in any way (e.g. elevators, traffic lights, being kept waiting)","-1"));
        mentalQuestions.add(new MentalQuestionModel("I had a feeling of faintness","-1"));
        mentalQuestions.add(new MentalQuestionModel("I felt that I had lost interest in just about everything","-1"));
        mentalQuestions.add(new MentalQuestionModel("I felt I wasn't worth much as a person","-1"));
        mentalQuestions.add(new MentalQuestionModel("I felt that I was rather touchy","-1"));
        mentalQuestions.add(new MentalQuestionModel("I perspired noticeably (e.g. hands sweaty) in the absence of high temperatures or physical exertion","-1"));
        mentalQuestions.add(new MentalQuestionModel("I felt scared without any good reason","-1"));
        mentalQuestions.add(new MentalQuestionModel("I felt that life wasn't worthwhile","-1"));

    }

    public void setSelfHealthQuestions() {

        if(!selfHealthQuestions.isEmpty())
            return;

        selfHealthQuestions.add(new MentalQuestionModel("Are you ready and committed to adopt a routine that will improve your long-term health?","5"));
        selfHealthQuestions.add(new MentalQuestionModel("How knowledgeable are you in regard to caloric intake, caloric deficit, and macronutrient information?","5"));
        selfHealthQuestions.add(new MentalQuestionModel("Do you understand exercise requirement when it comes to long-term health benefits. Specifically exercise frequency, duration and intensity?","5"));
        selfHealthQuestions.add(new MentalQuestionModel("How knowledgeable are you when it comes to sleep and recovery?","5"));
        selfHealthQuestions.add(new MentalQuestionModel("The most important variable in our long-term health is support. Do you feel mentally, emotionally and physically supported?","5"));


    }

}
