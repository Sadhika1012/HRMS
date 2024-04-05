package com.example.hrms.service;



import com.example.hrms.domain.Query;

public interface QueryService {
    Query postQuery(Query query);
    Query respondToQuery(int queryId, String response);
    Object getAllQueries();
    Object getQueriesByEmployeeId(int employeeId);
}

