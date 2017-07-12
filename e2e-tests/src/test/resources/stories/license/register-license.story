Register license key

Meta:
@tag license:register
@author Venkata Ravuri

Narrative:
As a Procurment Contact of an organizaiton or company which procured VMware product
I want to register licensy key with VMware
So that I can manage it

Scenario: Register a license key of a boxed copy of VMware Fusion and Workstation
Given I have a active MyVMware <account> with a registered VMware Fusion/Workstation <product>
When I request to register a <licenseKey>
Then I expect license key should be registered

Examples:
|account|product|licenseKey|
|peter@example.com|VMFUSION-1|OUWRR-X29SP-X2MZU-ZU2NC-PX10V|