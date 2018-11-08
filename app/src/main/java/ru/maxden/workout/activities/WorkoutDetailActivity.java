package ru.maxden.workout.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import ru.maxden.workout.Model.Workout;
import ru.maxden.workout.Model.WorkoutList;
import ru.maxden.workout.R;
import ru.maxden.workout.utils.Constants;


public class WorkoutDetailActivity extends AppCompatActivity {
	private TextView title;
	private TextView recordDate;
	private TextView recordRepsCount;
	private TextView recordWeight;
	private TextView description;
	private TextView weight;
	private ImageView image;
	private SeekBar weightSeekBar;
	private EditText repsCountEditText;
	private Button saveRecordButton;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workout_detail);
		Intent intent = getIntent();
		int index = intent.getIntExtra(Constants.WORKOUT_INDEX, 0);
		Workout workout = WorkoutList.getInstance().getWorkouts().get(index);
		initGUI(workout);
		addListeners();
	}

	private void addListeners() {
		weightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
				weight.setText(String.valueOf(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});
	}

	private void initGUI(Workout workout) {
		title = findViewById(R.id.workout_detail_title);
		title.setText(workout.getTitle());
		recordDate = findViewById(R.id.workout_detail_record_date);
		recordDate.setText(workout.getFormattedRecordDate());
		recordRepsCount = findViewById(R.id.workout_detail_record_reps_count);
		recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
		recordWeight = findViewById(R.id.workout_detail_record_weight);
		recordWeight.setText(String.valueOf(workout.getRecordWeight()));
		description = findViewById(R.id.workout_detail_description);
		description.setText(workout.getDescription());

		weight = findViewById(R.id.workout_detail_weight);
		weightSeekBar = findViewById(R.id.workout_detail_weight_seek_bar);
		repsCountEditText = findViewById(R.id.workout_detail_reps_count_edit_text);
		saveRecordButton = findViewById(R.id.workout_detail_save_button);
	}


}
