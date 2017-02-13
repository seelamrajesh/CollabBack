package com.niit.chat.dao;

import java.util.List;

import com.niii.chat.model.Jobs;



public interface JobsDao {
void addJobs(Jobs jobs);
List<Jobs> viewJobs();

void deleteJob(Jobs jobs);
void updateJob(Jobs jobs);

}