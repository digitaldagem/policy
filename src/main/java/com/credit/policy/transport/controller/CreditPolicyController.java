package com.credit.policy.transport.controller;

import com.credit.policy.service.PolicyCheck;
import com.credit.policy.storage.model.CreditPolicy;
import com.credit.policy.storage.repository.CreditPolicyRepository;
import com.credit.policy.transport.dto.CreditPolicyRequestValue;
import com.credit.policy.transport.dto.CreditPolicyResponseValue;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
public class CreditPolicyController {

    private final CreditPolicyRepository creditPolicyRepository;

    public CreditPolicyController(CreditPolicyRepository creditPolicyRepository) {
        this.creditPolicyRepository = creditPolicyRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CreditPolicy>> getAllCreditPolicies() {
        return ResponseEntity.ok(creditPolicyRepository.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<?> postCreditPolicy(@RequestBody CreditPolicyRequestValue creditPolicyRequestValue) throws URISyntaxException {
        if (creditPolicyRequestValue.validate()) {
            CreditPolicy creditPolicy = new CreditPolicy(
                    UUID.randomUUID(),
                    creditPolicyRequestValue.getCustomerAge(),
                    creditPolicyRequestValue.getCustomerDebt(),
                    creditPolicyRequestValue.getCustomerIncome(),
                    creditPolicyRequestValue.getPaymentRemarks(),
                    creditPolicyRequestValue.getPaymentRemarks12m()
            );
            String result = PolicyCheck.checkPolicy(creditPolicy);
            if ("ACCEPT".equals(result)) {
                creditPolicyRepository.save(creditPolicy);
                URI location = new URI("/policy_request/"+creditPolicy.getId());
                return ResponseEntity.created(location).body(new CreditPolicyResponseValue(result));
            } else {
                return ResponseEntity.ok(new CreditPolicyResponseValue(result));
            }
        } else {
            return ResponseEntity.badRequest().body("not a valid request object");
        }
    }
}
