package sample;

import javax.validation.constraints.NotBlank;

public class SampleRequest {
    @NotBlank
    private String sample;

    public String getSample() {
        return sample;
    }

    public SampleRequest setSample(String sample) {
        this.sample = sample;
        return this;
    }
}
