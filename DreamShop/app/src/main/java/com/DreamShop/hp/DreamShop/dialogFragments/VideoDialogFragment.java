package com.DreamShop.hp.DreamShop.dialogFragments;

import android.app.DialogFragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.DreamShop.hp.DreamShop.R;
import com.DreamShop.hp.DreamShop.providers.ProdProvider;

public class VideoDialogFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.video_item, container, false);
        initializationVideoView(v);
        return v;
    }

    private void initializationVideoView(View view) {
        final VideoView videoView = view.findViewById(R.id.infoVideo);
        videoView.setVideoURI(Uri.parse(ProdProvider.getItemPosition().getVideoUrl()));
        MediaController mediaController = new MediaController(getDialog().getContext());
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
