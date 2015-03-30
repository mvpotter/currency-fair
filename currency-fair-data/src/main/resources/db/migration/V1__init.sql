create table trade (
  id bigserial,
  user_id bigint not null,
  currency_from varchar(3) not null,
  currency_to varchar(3) not null,
  amount_Sell decimal not null,
  amount_buy decimal not null,
  rate decimal not null,
  time_placed timestamp not null,
  originating_country varchar(2) not null
);