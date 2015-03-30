[![Build Status](https://travis-ci.org/mvpotter/currency-fair.svg?branch=master)](https://travis-ci.org/mvpotter/currency-fair)

# CurrencyFair Engineering Test

- Consumer endpoint has basic authentication: user = currency, password = fair
- Rate limiting is implemented: by default the limit is 300 rps for post requests (could be changed in application.yml, currency-fair-rest module)
