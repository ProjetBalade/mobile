package be.hevelaska.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import be.hevelaska.mobile.databinding.ActivityMessageBinding;
import be.hevelaska.mobile.data.model.comment.DtoComment;
import be.hevelaska.mobile.data.model.comment.DtoCreateComment;
import be.hevelaska.mobile.data.model.dog.DtoCreateDog;
import be.hevelaska.mobile.data.model.dog.DtoDog;
import be.hevelaska.mobile.data.model.message.DtoCreateMessage;
import be.hevelaska.mobile.data.model.message.DtoMessages;
import be.hevelaska.mobile.data.model.ride.DtoCreateRide;
import be.hevelaska.mobile.data.model.ride.DtoRides;
import be.hevelaska.mobile.data.model.user.DtoCreateUser;
import be.hevelaska.mobile.data.model.user.DtoUser;
import be.hevelaska.mobile.infrastructure.ICommentsService;
import be.hevelaska.mobile.infrastructure.IDogsService;
import be.hevelaska.mobile.infrastructure.IMessagesService;
import be.hevelaska.mobile.infrastructure.IRidesService;
import be.hevelaska.mobile.infrastructure.IUsersService;
import be.hevelaska.mobile.infrastructure.RetrofitWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageActivity extends AppCompatActivity {

    private ActivityMessageBinding binding;

    private IUsersService usersService;
    private IRidesService ridesService;
    private IDogsService dogsService;
    private IMessagesService messagesService;
    private ICommentsService commentsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        usersService = RetrofitWrapper.getInstance().create(IUsersService.class);
        ridesService = RetrofitWrapper.getInstance().create(IRidesService.class);
        dogsService = RetrofitWrapper.getInstance().create(IDogsService.class);
        messagesService = RetrofitWrapper.getInstance().create(IMessagesService.class);
        commentsService = RetrofitWrapper.getInstance().create(ICommentsService.class);

        binding.getAllUsersButton.setOnClickListener(view -> getCommentsAndLog());
        binding.getUserByIdButton.setOnClickListener(view -> getCommentByIdLog());
        binding.deleteUserButton.setOnClickListener(view -> deleteCommentAndLog());
        binding.updateUserButton.setOnClickListener(view -> updateCommentAndLog());
        binding.createUserButton.setOnClickListener(view -> createCommentAndLog());

    }
    // test commentaire
    private void getCommentsAndLog() {
        commentsService.getAll(2)
                .enqueue(new Callback<List<DtoComment>>() {
                    @Override
                    public void onResponse(Call<List<DtoComment>> call, Response<List<DtoComment>> response) {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.i("COMMENTS", response.body().get(i).toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DtoComment>> call, Throwable t) {
                        Log.e("COMMENTS", "Error getting all comments");
                        Log.e("COMMENTS", t.getMessage());
                    }
                });
    }

    private void getCommentByIdLog(){
        commentsService.getById(2)
                .enqueue(new Callback<DtoComment>() {
                    @Override
                    public void onResponse(Call<DtoComment> call, Response<DtoComment> response) {
                        Log.i("COMMENTS", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<DtoComment> call, Throwable t) {
                        Log.e("COMMENTS", "Error get message");

                    }
                });
    }

    private void deleteCommentAndLog(){
        commentsService.delete(7)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("COMMENTS","commentaire supprimer");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("COMMENTS", "Error delete comment");
                    }
                });
    }

    private void updateCommentAndLog(){
        commentsService.update(5,new DtoComment(5,"contenu du commentaire",2,5,1,1))
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("COMMENTS","Todo updated");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("COMMENTS", "Error update message");
                    }
                });
    }

    private void createCommentAndLog(){
        commentsService.create(new DtoCreateComment("text",1,4,2,2))
                .enqueue(new Callback<DtoComment>() {
                    @Override
                    public void onResponse(Call<DtoComment> call, Response<DtoComment> response) {
                        Log.i("COMMENTS", "commentaire created");
                    }

                    @Override
                    public void onFailure(Call<DtoComment> call, Throwable t) {
                        Log.e("COMMENTS", "Error create commentaire");
                    }
                });
    }
    // test message
    private void getMessagesAndLog() {
        messagesService.getAll()
                .enqueue(new Callback<List<DtoMessages>>() {
                    @Override
                    public void onResponse(Call<List<DtoMessages>> call, Response<List<DtoMessages>> response) {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.i("MESSAGES", response.body().get(i).toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DtoMessages>> call, Throwable t) {
                        Log.e("MESSAGES", "Error getting all dogs");
                        Log.e("MESSAGES", t.getMessage());
                    }
                });
    }

    private void getMessageByIdLog(){
        messagesService.getById(3)
                .enqueue(new Callback<DtoMessages>() {
                    @Override
                    public void onResponse(Call<DtoMessages> call, Response<DtoMessages> response) {
                        Log.i("MESSAGES", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<DtoMessages> call, Throwable t) {
                        Log.e("MESSAGES", "Error get message");

                    }
                });
    }

    private void deleteMessageAndLog(){
        messagesService.delete(4)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("MESSAGES","message supprimer");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("MESSAGES", "Error delete message");
                    }
                });
    }

    private void updateMessageAndLog(){
        messagesService.update(3,new DtoMessages(3,1,2,"2021-12-15","ceci est un objet"))
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("MESSAGES","Todo updated");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("MESSAGES", "Error update message");
                    }
                });
    }

    private void createMessageAndLog(){
        messagesService.create(new DtoCreateMessage(2,1,"new message","test creation message"))
                .enqueue(new Callback<DtoMessages>() {
                    @Override
                    public void onResponse(Call<DtoMessages> call, Response<DtoMessages> response) {
                        Log.i("MESSAGES", "message created");
                    }

                    @Override
                    public void onFailure(Call<DtoMessages> call, Throwable t) {
                        Log.e("MESSAGES", "Error create message");
                    }
                });
    }

    // test dog
    private void getDogsAndLog() {
        dogsService.getAll()
                .enqueue(new Callback<List<DtoDog>>() {
                    @Override
                    public void onResponse(Call<List<DtoDog>> call, Response<List<DtoDog>> response) {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.i("DOGS", response.body().get(i).toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DtoDog>> call, Throwable t) {
                        Log.e("DOGS", "Error getting all dogs");
                        Log.e("DOGS", t.getMessage());
                    }
                });
    }

    private void getDogByIdLog(){
        dogsService.getById(5)
                .enqueue(new Callback<DtoDog>() {
                    @Override
                    public void onResponse(Call<DtoDog> call, Response<DtoDog> response) {
                        Log.i("DOGS", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<DtoDog> call, Throwable t) {
                        Log.e("DOGS", "Error get dog");

                    }
                });
    }

    private void deleteDogAndLog(){
        dogsService.delete(8)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("DOGS","dog supprimer");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("DOGS", "Error delete dog");
                    }
                });
    }



    
    // test ride

    private void getRidesAndLog() {
        ridesService.getAll()
                .enqueue(new Callback<List<DtoRides>>() {
                    @Override
                    public void onResponse(Call<List<DtoRides>> call, Response<List<DtoRides>> response) {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.i("RIDES", response.body().get(i).toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DtoRides>> call, Throwable t) {
                        Log.e("RIDES", "Error getting all rides");
                        Log.e("RIDES", t.getMessage());
                    }
                });
    }

    private void getRideByIdLog(){
        ridesService.getById(2)
                .enqueue(new Callback<DtoRides>() {
                    @Override
                    public void onResponse(Call<DtoRides> call, Response<DtoRides> response) {
                        Log.i("RIDES", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<DtoRides> call, Throwable t) {
                        Log.e("RIDES", "Error get ride");

                    }
                });
    }

    private void deleteRideAndLog(){
        ridesService.delete(5)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("RIDES","ride supprimer");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("RIDES", "Error delete ride");
                    }
                });
    }

    private void updateRideAndLog(){
        ridesService.update(2,new DtoRides(2,"mont a gourmet","place du village","restaurant pour smourbiff","http:montagourmet",4,"heures","photo ici",3,1,1234,456))
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("RIDES","Todo updated");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("RIDES", "Error get user");
                    }
                });
    }


    // test user
    private void getUsersAndLog() {
        usersService.getAll()
                .enqueue(new Callback<List<DtoUser>>() {
                    @Override
                    public void onResponse(Call<List<DtoUser>> call, Response<List<DtoUser>> response) {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.i("USERS", response.body().get(i).toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DtoUser>> call, Throwable t) {
                        Log.e("USERS", "Error getting all users");
                        Log.e("USERS", t.getMessage());
                    }
                });
    }

    private void getUserByIdLog(){
        usersService.getById(2)
                .enqueue(new Callback<DtoUser>() {
                    @Override
                    public void onResponse(Call<DtoUser> call, Response<DtoUser> response) {
                        Log.i("USERS", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<DtoUser> call, Throwable t) {
                        Log.e("USERS", "Error get user");

                    }
                });
    }

    private void deleteUserAndLog(){
        usersService.delete(7)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("USERS","user supprimer");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("USERS", "Error get user");
                    }
                });
    }



    private void updateUserAndLog(){
        usersService.update(2,new DtoUser(2,"rabhaTestPutMobile","emailtest","mdps"))
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("USERS","Todo updated");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("USERS", "Error get user");
                    }
                });
    }

    private void createUserAndLog(){
        usersService.create(new DtoCreateUser("dylan","dylan@mail","1234"))
                .enqueue(new Callback<DtoUser>() {
                    @Override
                    public void onResponse(Call<DtoUser> call, Response<DtoUser> response) {
                        Log.i("USERS", "user created");
                    }

                    @Override
                    public void onFailure(Call<DtoUser> call, Throwable t) {
                        Log.e("USERS", "Error create user");
                    }
                });
    }


}