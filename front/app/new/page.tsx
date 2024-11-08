"use client";
import { TextField } from "actify";
import { useState } from "react";

export default function NewCommentPage() {
  const [comment, setComment] = useState("");

  return (
    <div className="flex flex-col h-screen">
      <div className="text-2xl">新建留言</div>
      <textarea
        rows={20}
        className="bg-surface-variant border-2 border-black"
      />
    </div>
  );
}
