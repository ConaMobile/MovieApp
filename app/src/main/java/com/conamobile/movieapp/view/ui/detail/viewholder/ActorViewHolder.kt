package com.conamobile.movieapp.view.ui.detail.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.conamobile.movieapp.domain.pojo.Actor
import com.conamobile.movieapp.util.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.actor_view_layout.view.*

class ActorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(
        actor: Actor?
    ) {
        if (actor != null) {
            itemView.tvActorValue.text = actor.name
            Picasso.get().load(Constants.BASE_IMAGE_URL_w500_API + actor.profile_path).into(itemView.ivActor)
        }
    }

}