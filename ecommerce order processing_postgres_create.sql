CREATE TABLE "order_details" (
	"order_id" serial,
	"order_status" varchar(255) NOT NULL,
	"order_subtotal" FLOAT NOT NULL,
	"order_tax" FLOAT NOT NULL,
	"order_shipping_charges" FLOAT NOT NULL,
	"order_total" FLOAT NOT NULL,
	"item_id" integer NOT NULL,
	CONSTRAINT "order_details_pk" PRIMARY KEY ("order_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "orders" (
	"order_id" serial,
	"customer_id" integer NOT NULL,
	"payment_id" integer NOT NULL UNIQUE,
	"order_date_created" DATETIME NOT NULL,
	"order_date_modified" DATETIME NOT NULL,
	"order_delivery_method" varchar(255) NOT NULL,
	CONSTRAINT "orders_pk" PRIMARY KEY ("order_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "payment" (
	"payment_id" integer UNIQUE,
	"payment_method" VARCHAR(255),
	"payment_date" DATETIME NOT NULL,
	"payment_confirmation_number" integer NOT NULL,
	CONSTRAINT "payment_pk" PRIMARY KEY ("payment_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "customers" (
	"customer_id" serial NOT NULL,
	"billing_zip_id" varchar(255) NOT NULL,
	"shipping_addressline1" varchar(255) NOT NULL,
	"shipping_addressline2" varchar(255) NOT NULL,
	"shipping_zip" varchar(255) NOT NULL,
	"credit_card_details" varchar(255) NOT NULL,
	CONSTRAINT "customers_pk" PRIMARY KEY ("customer_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "order_items" (
	"item_id" serial NOT NULL UNIQUE,
	"item_name" varchar(255) NOT NULL,
	"item_description" varchar(255),
	"item_qty" serial NOT NULL,
	"item_price" serial NOT NULL,
	CONSTRAINT "order_items_pk" PRIMARY KEY ("item_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "billing_zip_codes" (
	"billing_zip_id" integer NOT NULL,
	"billing_state" VARCHAR(255) NOT NULL,
	"billing_city" VARCHAR(255) NOT NULL,
	CONSTRAINT "billing_zip_codes_pk" PRIMARY KEY ("billing_zip_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "shipping_zip_codes" (
	"shipping_zip_id" integer NOT NULL,
	"shipping_state" VARCHAR(255) NOT NULL,
	"shipping_city" VARCHAR(255) NOT NULL,
	CONSTRAINT "shipping_zip_codes_pk" PRIMARY KEY ("shipping_zip_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "credit_card_details" (
	"credit_card_id" integer NOT NULL,
	"credit_card_number" VARCHAR(255) NOT NULL,
	"credit_card_type" varchar(255) NOT NULL,
	"credit_card_exp_date" DATE(255) NOT NULL,
	"billing_addressline1" varchar(255) NOT NULL,
	"billing_addressline2" varchar(255) NOT NULL,
	"billing_zip_id" integer(255) NOT NULL,
	"customer_id" integer(255) NOT NULL,
	CONSTRAINT "credit_card_details_pk" PRIMARY KEY ("credit_card_number")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "delivery_method" (
	"order_id" integer NOT NULL,
	"delivery_type" VARCHAR(255) NOT NULL,
	"delivery_charge" FLOAT(255) NOT NULL,
	"delivery_date" DATE(255) NOT NULL,
	CONSTRAINT "delivery_method_pk" PRIMARY KEY ("order_id")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "order_details" ADD CONSTRAINT "order_details_fk0" FOREIGN KEY ("order_id") REFERENCES "orders"("order_id");


ALTER TABLE "payment" ADD CONSTRAINT "payment_fk0" FOREIGN KEY ("payment_id") REFERENCES "orders"("payment_id");

ALTER TABLE "customers" ADD CONSTRAINT "customers_fk0" FOREIGN KEY ("customer_id") REFERENCES "orders"("customer_id");

ALTER TABLE "order_items" ADD CONSTRAINT "order_items_fk0" FOREIGN KEY ("item_id") REFERENCES "order_details"("item_id");

ALTER TABLE "billing_zip_codes" ADD CONSTRAINT "billing_zip_codes_fk0" FOREIGN KEY ("billing_zip_id") REFERENCES "credit_card_details"("billing_zip_id");

ALTER TABLE "shipping_zip_codes" ADD CONSTRAINT "shipping_zip_codes_fk0" FOREIGN KEY ("shipping_zip_id") REFERENCES "customers"("shipping_zip");

ALTER TABLE "credit_card_details" ADD CONSTRAINT "credit_card_details_fk0" FOREIGN KEY ("credit_card_id") REFERENCES "customers"("credit_card_details");
ALTER TABLE "credit_card_details" ADD CONSTRAINT "credit_card_details_fk1" FOREIGN KEY ("customer_id") REFERENCES "customers"("customer_id");

ALTER TABLE "delivery_method" ADD CONSTRAINT "delivery_method_fk0" FOREIGN KEY ("order_id") REFERENCES "orders"("order_id");
ALTER TABLE "delivery_method" ADD CONSTRAINT "delivery_method_fk1" FOREIGN KEY ("delivery_type") REFERENCES "orders"("order_delivery_method");

