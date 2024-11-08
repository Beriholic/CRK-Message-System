import React, { useCallback, useRef } from "react";
import Captcha from "react-captcha-code";

export default function CaptchaCode({
  captchaChange,
  captchaLength,
}: Readonly<{
  captchaChange: (value: string) => void;
  captchaLength: number;
}>) {
  const handleChange = useCallback(
    (captcha: string) => {
      captchaChange(captcha);
      console.log("captcha:", captcha);
    },
    [captchaChange]
  );

  const captchaRef = useRef<HTMLCanvasElement>(null);

  return (
    <>
      <Captcha
        ref={captchaRef}
        charNum={captchaLength}
        onChange={handleChange}
      />
    </>
  );
}
