package com.ridoy.unknowncaller.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ridoy.unknowncaller.R;
import com.ridoy.unknowncaller.SharedPreferencemanager.SharedPrefManager;
import com.ridoy.unknowncaller.databinding.ActivityRewardBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class RewardActivity extends AppCompatActivity {

    ActivityRewardBinding binding;
    private RewardedAd mRewardedAd;
    FirebaseDatabase database;
    String currentUid;
    int coins = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRewardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = FirebaseDatabase.getInstance();
        currentUid = FirebaseAuth.getInstance().getUid();
        loadAd();

        database.getReference().child("profiles")
                .child(currentUid)
                .child("coins")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        coins = snapshot.getValue(Integer.class);
                        binding.coins.setText(String.valueOf(coins));
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });

        binding.video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedPrefManager.getInstance(RewardActivity.this).getVideo1Status() == 1) {
                    binding.video1Icon.setImageResource(R.drawable.check);
                    Toast.makeText(RewardActivity.this, "Already Collected", Toast.LENGTH_SHORT).show();
                } else {
                    if (mRewardedAd != null) {
                        Activity activityContext = RewardActivity.this;
                        mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                loadAd();
                                coins = coins + 5;
                                database.getReference().child("profiles")
                                        .child(currentUid)
                                        .child("coins")
                                        .setValue(coins);
                                binding.video1Icon.setImageResource(R.drawable.check);
                                SharedPrefManager.getInstance(RewardActivity.this).setVideo1Status(1);
                            }
                        });
                    } else {
                        loadAd();
                        Toast.makeText(RewardActivity.this, "Something went wrong. Try sometimes later", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedPrefManager.getInstance(RewardActivity.this).getVideo2Status() == 1) {
                    binding.video2Icon.setImageResource(R.drawable.check);
                    Toast.makeText(RewardActivity.this, "Already Collected", Toast.LENGTH_SHORT).show();
                } else {
                    if (mRewardedAd != null) {
                        Activity activityContext = RewardActivity.this;
                        mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                loadAd();
                                coins = coins + 10;
                                database.getReference().child("profiles")
                                        .child(currentUid)
                                        .child("coins")
                                        .setValue(coins);
                                binding.video2Icon.setImageResource(R.drawable.check);
                                SharedPrefManager.getInstance(RewardActivity.this).setVideo2Status(1);
                            }
                        });
                    } else {
                        loadAd();
                        Toast.makeText(RewardActivity.this, "Something went wrong. Try sometimes later", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedPrefManager.getInstance(RewardActivity.this).getVideo3Status() == 1) {
                    binding.video3Icon.setImageResource(R.drawable.check);
                    Toast.makeText(RewardActivity.this, "Already Collected", Toast.LENGTH_SHORT).show();
                } else {
                    if (mRewardedAd != null) {
                        Activity activityContext = RewardActivity.this;
                        mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                loadAd();
                                coins = coins + 15;
                                database.getReference().child("profiles")
                                        .child(currentUid)
                                        .child("coins")
                                        .setValue(coins);
                                binding.video3Icon.setImageResource(R.drawable.check);
                                SharedPrefManager.getInstance(RewardActivity.this).setVideo3Status(1);
                            }
                        });
                    } else {
                        loadAd();
                        Toast.makeText(RewardActivity.this, "Something went wrong. Try sometimes later", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.video4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedPrefManager.getInstance(RewardActivity.this).getVideo4Status() == 1) {
                    binding.video4Icon.setImageResource(R.drawable.check);
                    Toast.makeText(RewardActivity.this, "Already Collected", Toast.LENGTH_SHORT).show();
                } else {
                    if (mRewardedAd != null) {
                        Activity activityContext = RewardActivity.this;
                        mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                loadAd();
                                coins = coins + 20;
                                database.getReference().child("profiles")
                                        .child(currentUid)
                                        .child("coins")
                                        .setValue(coins);
                                binding.video4Icon.setImageResource(R.drawable.check);
                                SharedPrefManager.getInstance(RewardActivity.this).setVideo4Status(1);
                            }
                        });
                    } else {
                        loadAd();
                        Toast.makeText(RewardActivity.this, "Something went wrong. Try sometimes later", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.video5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedPrefManager.getInstance(RewardActivity.this).getVideo5Status() == 1) {
                    binding.video5Icon.setImageResource(R.drawable.check);
                    Toast.makeText(RewardActivity.this, "Already Collected", Toast.LENGTH_SHORT).show();
                } else {
                    if (mRewardedAd != null) {
                        Activity activityContext = RewardActivity.this;
                        mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                loadAd();
                                coins = coins + 25;
                                database.getReference().child("profiles")
                                        .child(currentUid)
                                        .child("coins")
                                        .setValue(coins);
                                binding.video5Icon.setImageResource(R.drawable.check);
                                SharedPrefManager.getInstance(RewardActivity.this).setVideo5Status(1);
                            }
                        });
                    } else {
                        loadAd();
                        Toast.makeText(RewardActivity.this, "Something went wrong. Try sometimes later", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.video6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedPrefManager.getInstance(RewardActivity.this).getVideo6Status() == 1) {
                    binding.video6Icon.setImageResource(R.drawable.check);
                    Toast.makeText(RewardActivity.this, "Already Collected", Toast.LENGTH_SHORT).show();
                } else {
                    if (mRewardedAd != null) {
                        Activity activityContext = RewardActivity.this;
                        mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                loadAd();
                                coins = coins + 50;
                                database.getReference().child("profiles")
                                        .child(currentUid)
                                        .child("coins")
                                        .setValue(coins);
                                binding.video6Icon.setImageResource(R.drawable.check);
                                SharedPrefManager.getInstance(RewardActivity.this).setVideo6Status(1);
                            }
                        });
                    } else {
                        loadAd();
                        Toast.makeText(RewardActivity.this, "Something went wrong. Try sometimes later", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.video7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedPrefManager.getInstance(RewardActivity.this).getVideo7Status() == 1) {
                    binding.video7Icon.setImageResource(R.drawable.check);
                    Toast.makeText(RewardActivity.this, "Already Collected", Toast.LENGTH_SHORT).show();
                } else {
                    if (mRewardedAd != null) {
                        Activity activityContext = RewardActivity.this;
                        mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                loadAd();
                                coins = coins + 75;
                                database.getReference().child("profiles")
                                        .child(currentUid)
                                        .child("coins")
                                        .setValue(coins);
                                binding.video7Icon.setImageResource(R.drawable.check);
                                SharedPrefManager.getInstance(RewardActivity.this).setVideo7Status(1);
                            }
                        });
                    } else {
                        loadAd();
                        Toast.makeText(RewardActivity.this, "Something went wrong. Try sometimes later", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.video8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedPrefManager.getInstance(RewardActivity.this).getVideo8Status() == 1) {
                    binding.video8Icon.setImageResource(R.drawable.check);
                    Toast.makeText(RewardActivity.this, "Already Collected", Toast.LENGTH_SHORT).show();
                } else {
                    if (mRewardedAd != null) {
                        Activity activityContext = RewardActivity.this;
                        mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                loadAd();
                                coins = coins + 100;
                                database.getReference().child("profiles")
                                        .child(currentUid)
                                        .child("coins")
                                        .setValue(coins);
                                binding.video8Icon.setImageResource(R.drawable.check);
                                SharedPrefManager.getInstance(RewardActivity.this).setVideo8Status(1);
                            }
                        });
                    } else {
                        loadAd();
                        Toast.makeText(RewardActivity.this, "Something went wrong. Try sometimes later", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.video9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedPrefManager.getInstance(RewardActivity.this).getVideo9Status() == 1) {
                    binding.video9Icon.setImageResource(R.drawable.check);
                    Toast.makeText(RewardActivity.this, "Already Collected", Toast.LENGTH_SHORT).show();
                } else {
                    if (mRewardedAd != null) {
                        Activity activityContext = RewardActivity.this;
                        mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                loadAd();
                                coins = coins + 125;
                                database.getReference().child("profiles")
                                        .child(currentUid)
                                        .child("coins")
                                        .setValue(coins);
                                binding.video9Icon.setImageResource(R.drawable.check);
                                SharedPrefManager.getInstance(RewardActivity.this).setVideo9Status(1);
                            }
                        });
                    } else {
                        loadAd();
                        Toast.makeText(RewardActivity.this, "Something went wrong. Try sometimes later", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.video10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedPrefManager.getInstance(RewardActivity.this).getVideo10Status() == 1) {
                    binding.video10Icon.setImageResource(R.drawable.check);
                    Toast.makeText(RewardActivity.this, "Already Collected", Toast.LENGTH_SHORT).show();
                } else {
                    if (mRewardedAd != null) {
                        Activity activityContext = RewardActivity.this;
                        mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                loadAd();
                                coins = coins + 20;
                                database.getReference().child("profiles")
                                        .child(currentUid)
                                        .child("coins")
                                        .setValue(coins);
                                binding.video10Icon.setImageResource(R.drawable.check);
                                SharedPrefManager.getInstance(RewardActivity.this).setVideo10Status(1);
                            }
                        });
                    } else {
                        loadAd();
                        Toast.makeText(RewardActivity.this, "Something went wrong. Try sometimes later", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    void loadAd() {
        AdRequest adRequest = new AdRequest.Builder().build();

        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.

                        mRewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;
                    }
                });
    }


}