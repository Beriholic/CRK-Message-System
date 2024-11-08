"use client";
import { api } from "@/apis/ApiInstance";
import { CommentDto } from "@/apis/gen/model/dto";
import NavBar from "@/components/NavBar";
import Image from "next/image";
import { useEffect, useState } from "react";
import { motion } from "framer-motion";

export default function HomePage() {
  const [username, setUsername] = useState("");
  const [comments, setComments] = useState<
    Array<CommentDto["CommentController/BASE_COMMENT"]>
  >([]);

  const fetchUserInfo = async () => {
    const resp = await api.userController.userInfo();
    if (resp.code !== 200) {
      alert("获取用户信息失败");
      console.log(resp.msg);
      return;
    }

    setUsername(resp.data?.username ? resp.data.username : "");
    return;
  };

  const fetchComemntList = async () => {
    const res = await api.commentController.getComments({
      size: 100,
      offset: 0,
    });
    if (res.code !== 200) {
      return;
    }
    if (res.data == undefined || res.data?.length === 0) {
      return;
    }
    setComments(
      res.data as Array<CommentDto["CommentController/BASE_COMMENT"]>
    );
  };

  useEffect(() => {
    fetchUserInfo();
    fetchComemntList();
  }, []);

  const myLoader = ({}) => {
    return "https://tse3-mm.cn.bing.net/th/id/OIP-C.GZBa_hixAIn5uPFkv0J4NwHaHa?rs=1&pid=ImgDetMain";
  };

  return (
    <div className="flex flex-col h-screen">
      <NavBar username={username} />
      <div className="flex flex-col items-center justify-center gap-y-8">
        {comments.map((comment) => {
          return (
            <motion.div
              key={comment.id}
              className="bg-surface-container p-8 rounded-2xl w-[85%]"
              animate={{
                opacity: 1,
                y: 0,
              }}
              initial={{
                opacity: 0,
                y: -50,
              }}
              transition={{
                duration: 0.3,
              }}
            >
              <div className="flex items-center gap-x-8">
                <div className="flex flex-col">
                  <Image
                    className="rounded-full"
                    loader={myLoader}
                    width={50}
                    height={50}
                    alt="avatar"
                    src={
                      "https://tse3-mm.cn.bing.net/th/id/OIP-C.GZBa_hixAIn5uPFkv0J4NwHaHa?rs=1&pid=ImgDetMain"
                    }
                  />
                  <div className="text-center">{comment.username}</div>
                </div>
                <div>{comment.content}</div>
              </div>
            </motion.div>
          );
        })}
      </div>
    </div>
  );
}
