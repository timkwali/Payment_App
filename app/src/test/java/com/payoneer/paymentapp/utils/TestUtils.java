package com.payoneer.paymentapp.utils;

import androidx.annotation.Nullable;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class TestUtils {

    public static ResponseBody emptyResponseBody = ResponseBody.create(MediaType.parse("application/json"), "");

    public static <T> Call<T> fakeSuccessCall(@Nullable T body, int code) {
        return new Calls.FakeCall<>(Response.success(code, body), null);
    }

    public static <T> Call<T> fakeErrorCall(@Nullable T body, int code) {
        if(body == null) {
            body = (T) emptyResponseBody;
        }
        return new Calls.FakeCall<T>(Response.error(code, (ResponseBody) body), null);
    }


    public static String PAYMENT_RESPONSE = "{\n" +
            "    \"links\": {\n" +
            "        \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it\",\n" +
            "        \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/checkout.json\"\n" +
            "    },\n" +
            "    \"timestamp\": \"2021-04-14T09:16:46.796+0000\",\n" +
            "    \"operation\": \"LIST\",\n" +
            "    \"resultCode\": \"00000.11.000\",\n" +
            "    \"resultInfo\": \"17 applicable and 0 registered networks are found\",\n" +
            "    \"returnCode\": {\n" +
            "        \"name\": \"OK\",\n" +
            "        \"source\": \"GATEWAY\"\n" +
            "    },\n" +
            "    \"status\": {\n" +
            "        \"code\": \"listed\",\n" +
            "        \"reason\": \"listed\"\n" +
            "    },\n" +
            "    \"interaction\": {\n" +
            "        \"code\": \"PROCEED\",\n" +
            "        \"reason\": \"OK\"\n" +
            "    },\n" +
            "    \"identification\": {\n" +
            "        \"longId\": \"6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it\",\n" +
            "        \"shortId\": \"05753-51161\",\n" +
            "        \"transactionId\": \"20678\"\n" +
            "    },\n" +
            "    \"networks\": {\n" +
            "        \"applicable\": [\n" +
            "            {\n" +
            "                \"code\": \"AMEX\",\n" +
            "                \"label\": \"American Express\",\n" +
            "                \"method\": \"CREDIT_CARD\",\n" +
            "                \"grouping\": \"CREDIT_CARD\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/amex.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/AMEX\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/AMEX.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/AMEX/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/AMEX/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"number\",\n" +
            "                        \"type\": \"numeric\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryMonth\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryYear\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"verificationCode\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"holderName\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"DINERS\",\n" +
            "                \"label\": \"Diners Club\",\n" +
            "                \"method\": \"CREDIT_CARD\",\n" +
            "                \"grouping\": \"CREDIT_CARD\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/diners.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/DINERS\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/DINERS.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/DINERS/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/DINERS/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"number\",\n" +
            "                        \"type\": \"numeric\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryMonth\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryYear\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"verificationCode\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"holderName\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"DISCOVER\",\n" +
            "                \"label\": \"Discover\",\n" +
            "                \"method\": \"CREDIT_CARD\",\n" +
            "                \"grouping\": \"CREDIT_CARD\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/discover.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/DISCOVER\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/DISCOVER.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/DISCOVER/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/DISCOVER/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"number\",\n" +
            "                        \"type\": \"numeric\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryMonth\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryYear\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"verificationCode\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"holderName\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"IDEAL\",\n" +
            "                \"label\": \"iDEAL\",\n" +
            "                \"method\": \"ONLINE_BANK_TRANSFER\",\n" +
            "                \"grouping\": \"ONLINE_BANK_TRANSFER\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": true,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/ideal.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/IDEAL\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/IDEAL.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/IDEAL/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/IDEAL/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"bic\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"MAESTRO\",\n" +
            "                \"label\": \"Maestro\",\n" +
            "                \"method\": \"DEBIT_CARD\",\n" +
            "                \"grouping\": \"DEBIT_CARD\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/maestro.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MAESTRO\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/MAESTRO.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MAESTRO/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/MAESTRO/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"holderName\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"number\",\n" +
            "                        \"type\": \"numeric\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryYear\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryMonth\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"verificationCode\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"MASTERCARD\",\n" +
            "                \"label\": \"Mastercard\",\n" +
            "                \"method\": \"CREDIT_CARD\",\n" +
            "                \"grouping\": \"CREDIT_CARD\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/mastercard.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MASTERCARD\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/MASTERCARD.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MASTERCARD/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/MASTERCARD/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"number\",\n" +
            "                        \"type\": \"numeric\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryMonth\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryYear\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"verificationCode\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"holderName\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"MISTERCASH\",\n" +
            "                \"label\": \"Bancontact/Mister Cash\",\n" +
            "                \"method\": \"DEBIT_CARD\",\n" +
            "                \"grouping\": \"DEBIT_CARD\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/mistercash.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MISTERCASH\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/MISTERCASH.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MISTERCASH/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/MISTERCASH/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"number\",\n" +
            "                        \"type\": \"numeric\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryYear\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryMonth\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"PAYFAST\",\n" +
            "                \"label\": \"PayFast\",\n" +
            "                \"method\": \"WALLET\",\n" +
            "                \"grouping\": \"WALLET\",\n" +
            "                \"registration\": \"NONE\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": true,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/payfast.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/PAYFAST\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/PAYFAST.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/PAYFAST/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/PAYFAST/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"PAYPAL\",\n" +
            "                \"label\": \"PayPal\",\n" +
            "                \"method\": \"WALLET\",\n" +
            "                \"grouping\": \"WALLET\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": true,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/paypal.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/PAYPAL\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/PAYPAL.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/PAYPAL/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/PAYPAL/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"contractData\": {\n" +
            "                    \"PAGE_ENVIRONMENT\": \"sandbox\",\n" +
            "                    \"JAVASCRIPT_INTEGRATION\": \"false\",\n" +
            "                    \"PAGE_BUTTON_LOCALE\": \"en_US\"\n" +
            "                },\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"POSTEPAY\",\n" +
            "                \"label\": \"PostePay\",\n" +
            "                \"method\": \"DEBIT_CARD\",\n" +
            "                \"grouping\": \"DEBIT_CARD\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/postepay.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/POSTEPAY\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/POSTEPAY.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/POSTEPAY/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/POSTEPAY/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"holderName\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"number\",\n" +
            "                        \"type\": \"numeric\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryYear\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryMonth\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"verificationCode\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"RATEPAY\",\n" +
            "                \"label\": \"RatePAY Invoice\",\n" +
            "                \"method\": \"OPEN_INVOICE\",\n" +
            "                \"grouping\": \"OPEN_INVOICE\",\n" +
            "                \"registration\": \"NONE\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/ratepay.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/RATEPAY\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/RATEPAY.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/RATEPAY/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/RATEPAY/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"SEPADD\",\n" +
            "                \"label\": \"SEPA\",\n" +
            "                \"method\": \"DIRECT_DEBIT\",\n" +
            "                \"grouping\": \"DIRECT_DEBIT\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/sepadd.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/SEPADD\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/SEPADD.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/SEPADD/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/SEPADD/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"holderName\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"iban\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"bic\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"SOFORTUEBERWEISUNG\",\n" +
            "                \"label\": \"Online Bank Transfer\",\n" +
            "                \"method\": \"ONLINE_BANK_TRANSFER\",\n" +
            "                \"grouping\": \"ONLINE_BANK_TRANSFER\",\n" +
            "                \"registration\": \"NONE\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": true,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/sofort.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/SOFORTUEBERWEISUNG\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/SOFORTUEBERWEISUNG.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/SOFORTUEBERWEISUNG/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/SOFORTUEBERWEISUNG/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"UNIONPAY\",\n" +
            "                \"label\": \"UnionPay\",\n" +
            "                \"method\": \"CREDIT_CARD\",\n" +
            "                \"grouping\": \"CREDIT_CARD\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/unionpay.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/UNIONPAY\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/UNIONPAY.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/UNIONPAY/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/UNIONPAY/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"number\",\n" +
            "                        \"type\": \"numeric\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryMonth\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryYear\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"verificationCode\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"holderName\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"VISA\",\n" +
            "                \"label\": \"Visa\",\n" +
            "                \"method\": \"CREDIT_CARD\",\n" +
            "                \"grouping\": \"CREDIT_CARD\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/visa.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/VISA\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/VISA.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/VISA/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/VISA/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"number\",\n" +
            "                        \"type\": \"numeric\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryMonth\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryYear\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"verificationCode\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"holderName\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"VISAELECTRON\",\n" +
            "                \"label\": \"Visa Electron\",\n" +
            "                \"method\": \"DEBIT_CARD\",\n" +
            "                \"grouping\": \"DEBIT_CARD\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/visaelectron.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/VISAELECTRON\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/VISAELECTRON.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/VISAELECTRON/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/VISAELECTRON/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"holderName\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"number\",\n" +
            "                        \"type\": \"numeric\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryYear\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryMonth\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"verificationCode\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"code\": \"VISA_DANKORT\",\n" +
            "                \"label\": \"Visa Dankort\",\n" +
            "                \"method\": \"DEBIT_CARD\",\n" +
            "                \"grouping\": \"DEBIT_CARD\",\n" +
            "                \"registration\": \"OPTIONAL\",\n" +
            "                \"recurrence\": \"NONE\",\n" +
            "                \"redirect\": false,\n" +
            "                \"links\": {\n" +
            "                    \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/visa_dankort.png\",\n" +
            "                    \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/VISA_DANKORT\",\n" +
            "                    \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/VISA_DANKORT.json\",\n" +
            "                    \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/VISA_DANKORT/charge\",\n" +
            "                    \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/VISA_DANKORT/standard/validate\"\n" +
            "                },\n" +
            "                \"selected\": false,\n" +
            "                \"inputElements\": [\n" +
            "                    {\n" +
            "                        \"name\": \"number\",\n" +
            "                        \"type\": \"numeric\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryMonth\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"expiryYear\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"verificationCode\",\n" +
            "                        \"type\": \"integer\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"holderName\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"operationType\": \"CHARGE\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"operationType\": \"CHARGE\",\n" +
            "    \"style\": {\n" +
            "        \"language\": \"en_US\"\n" +
            "    },\n" +
            "    \"payment\": {\n" +
            "        \"reference\": \"Mobile Team Exercise\",\n" +
            "        \"amount\": 13,\n" +
            "        \"currency\": \"EUR\"\n" +
            "    },\n" +
            "    \"integrationType\": \"MOBILE_NATIVE\"\n" +
            "}";
}
