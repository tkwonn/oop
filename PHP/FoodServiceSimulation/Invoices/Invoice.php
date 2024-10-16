<?php

namespace Invoices;

date_default_timezone_set('Asia/Tokyo');
class Invoice
{
    protected float $finalPrice;
    protected string $issueTime;

    public function __construct(float $finalPrice)
    {
        $this->finalPrice = $finalPrice;
        $this->issueTime = time();
    }

    public function printInvoice(): void
    {
        $formattedDate = date('Y/m/d H:i:s', $this->issueTime);
        $separatorLine = str_repeat('-', 40);

        printf(
            "%s\nDate: %s\nFinal Price: $%.2f\n%s\n",
            $separatorLine,
            $formattedDate,
            $this->finalPrice,
            $separatorLine
        );
    }
}