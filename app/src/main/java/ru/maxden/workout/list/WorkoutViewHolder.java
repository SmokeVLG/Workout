package ru.maxden.workout.list;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ru.maxden.workout.Model.Workout;
import ru.maxden.workout.R;
import ru.maxden.workout.activities.WorkoutDetailActivity;
import ru.maxden.workout.utils.Constants;


/**
 * Created by maksim_de on 08.11.2018.
 */
class WorkoutViewHolder extends RecyclerView.ViewHolder {
	private TextView title;
	private TextView description;
	private TextView recordDate;
	private TextView recordRepsCount;
	private TextView recordWeight;
	private CardView cardView;

	public WorkoutViewHolder(@NonNull final View itemView) {
		super(itemView);
		title = itemView.findViewById(R.id.list_item_title_text_view);
		description = itemView.findViewById(R.id.list_item_deskription_text_view);
		recordDate = itemView.findViewById(R.id.list_item_record_date);
		recordRepsCount = itemView.findViewById(R.id.list_item_record_reps_count);
		recordWeight = itemView.findViewById(R.id.list_item_record_weight);
		cardView = itemView.findViewById(R.id.cardView);

	}

	public void bindView(Workout workout, final int index) {
		title.setText(workout.getTitle());
		description.setText(workout.getDescription());
		recordWeight.setText(String.valueOf(workout.getRecordWeight()));
		recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
		recordDate.setText(workout.getFormattedRecordDate());

		cardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Context context = itemView.getContext();
				Intent intent = new Intent(context, WorkoutDetailActivity.class);
				intent.putExtra(Constants.WORKOUT_INDEX, index);
				context.startActivity(intent);
			}
		});
	}



}