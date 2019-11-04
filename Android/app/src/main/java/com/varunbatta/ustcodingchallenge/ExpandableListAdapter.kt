package com.varunbatta.ustcodingchallenge

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpandableListAdapter constructor(context: Context, listDataHeader: List<String>, listDataChildren: HashMap<String, List<String>>): BaseExpandableListAdapter() {

    private var context: Context? = null
    private var listDataHeader: List<String>? = null
    private var listDataChildren: HashMap<String, List<String>>? = null

    init {
        this.context = context
        this.listDataHeader = listDataHeader
        this.listDataChildren = listDataChildren
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return this.listDataChildren!!.get(this.listDataHeader!!.get(groupPosition))!!.get(childPosition)
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var childText = getChild(groupPosition, childPosition)
        var currentConvertView = convertView
        if (convertView == null) {
            currentConvertView = View.inflate(context, R.layout.cv_section_details, null)
        }

        var cvSectionDetailsLabel = currentConvertView!!.findViewById<TextView>(R.id.cv_section_details_label)
        cvSectionDetailsLabel.setText(childText as String)

        return currentConvertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this.listDataChildren!!.get(this.listDataHeader!!.get(groupPosition))!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return this.listDataHeader!!.get(groupPosition)
    }

    override fun getGroupCount(): Int {
        return this.listDataHeader!!.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var headerTitle = getGroup(groupPosition)
        var currentConvertView = convertView

        if (convertView == null) {
            currentConvertView = View.inflate(context, R.layout.cv_section_header, null)
        }

        var cvSectionHeaderLabel = currentConvertView!!.findViewById<TextView>(R.id.cv_section_header_label)
        cvSectionHeaderLabel.setTypeface(Typeface.DEFAULT_BOLD)
        cvSectionHeaderLabel.setText(headerTitle as String)

        return currentConvertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}