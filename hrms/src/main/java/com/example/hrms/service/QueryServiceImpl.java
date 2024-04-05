package com.example.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.domain.Query;
import com.example.hrms.domain.Status;
import com.example.hrms.repository.QueryRepository;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryRepository queryRepository;

    @Override
    public Query postQuery(Query query) {
        return queryRepository.save(query);
    }

    @Override
    public Query respondToQuery(int queryId, String response) {
        Query query = queryRepository.findById(queryId).orElseThrow(() -> new RuntimeException("Query not found"));
        query.setResponse(response);
        query.setStatus(Status.CLOSED);
        return queryRepository.save(query);
    }
    @Override
    public List<Query> getAllQueries() {
        return queryRepository.findAll();
    }

    @Override
    public List<Query> getQueriesByEmployeeId(int employeeId) {
        return queryRepository.findByEmployeeId(employeeId);
    }
    
}
