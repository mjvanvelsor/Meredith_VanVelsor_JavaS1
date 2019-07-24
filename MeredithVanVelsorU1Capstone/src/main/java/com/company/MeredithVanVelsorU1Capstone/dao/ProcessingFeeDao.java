package com.company.MeredithVanVelsorU1Capstone.dao;

import com.company.MeredithVanVelsorU1Capstone.model.ProcessingFee;

public interface ProcessingFeeDao {

    ProcessingFee getProcessingFeeByType(String productType);

}
