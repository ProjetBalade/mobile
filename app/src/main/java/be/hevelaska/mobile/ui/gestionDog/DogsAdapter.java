package be.hevelaska.mobile.ui.gestionDog;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import be.hevelaska.mobile.data.model.dog.DtoDog;
import be.hevelaska.mobile.databinding.DogItemBinding;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder>{

    private List<DtoDog> dogs;
    private final OnDogClickListener onDogClickListener;
    private final OnDogClickListener onDeleteDog;
    private final OnDogClickListener onEditDog;

    public DogsAdapter(List<DtoDog> dogs, OnDogClickListener onDogClickListener, OnDogClickListener onDeleteDog,OnDogClickListener onEditDog) {
        this.dogs = dogs;
        this.onDogClickListener = onDogClickListener;
        this.onDeleteDog = onDeleteDog;
        this.onEditDog = onEditDog;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DogItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DtoDog dtoDog = dogs.get(position);
        holder.bind(dtoDog, onDogClickListener,onDeleteDog, onEditDog);
    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }

    public void setDogsList(List<DtoDog>dogs){
        this.dogs = dogs;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public DtoDog mItem;
        private final DogItemBinding binding;

        public ViewHolder(DogItemBinding binding) {
            super(binding.getRoot());
            this.binding= binding;

        }
        public void bind(DtoDog dog, OnDogClickListener onDogClickListener, OnDogClickListener onDogDeleteListener, OnDogClickListener onDogEdit){
            binding.nameDog.setText(dog.getNameDog());
            binding.raceDog.setText(dog.getRaceDog());


            binding.getRoot().setOnClickListener(v -> onDogClickListener.onClick(dog));
            binding.deleteBtn.setOnClickListener(view -> onDogDeleteListener.onClick(dog));
            binding.updateBtn.setOnClickListener(view -> onDogEdit.onClick(dog) );
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.getNameDog() + "'";
        }
    }

    public interface OnDogClickListener {
       void onClick(DtoDog dog);
    }


}
