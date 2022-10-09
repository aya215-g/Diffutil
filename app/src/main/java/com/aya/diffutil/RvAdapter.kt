package com.aya.diffutil
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aya.diffutil.databinding.SingleItemBinding
import java.util.Collections.emptyList


class RvAdapter() : RecyclerView.Adapter<RvAdapter.ViewHolder>() {


    private var oldLanguageList= emptyList<Language>()

    inner class ViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.tvLangName.text = oldLanguageList[position].name
        holder.binding.tvExp.text = oldLanguageList[position].name

    }

    override fun getItemCount(): Int {
        return oldLanguageList.size
    }

    fun setData(newLanguageList : List<Language>){
        val diffUtil = MyDiffUtil(oldLanguageList , newLanguageList)

        val diffResult = DiffUtil.calculateDiff(diffUtil)

        oldLanguageList = newLanguageList
        diffResult.dispatchUpdatesTo(this)
    }
}
