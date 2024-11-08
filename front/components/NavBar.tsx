import { Button } from "actify";
import { useRouter } from "next/navigation";

export default function NavBar({
  username,
}: Readonly<{
  username: string;
}>) {
  const router = useRouter();

  return (
    <div className="flex flex-row m-4 items-center justify-between bg-surface-variant p-5 rounded-2xl border-2 border-black">
      <div className="text-xl">重人科留言板</div>
      <div className="flex flex-row items-center gap-2">
        <Button
          variant="outlined"
          onClick={() => {
            router.push("/new");
          }}
        >
          新建留言
        </Button>
        <div className="text-[12px] text-opacity-70">当前用户: </div>
        <div className="text-base">{username}</div>
      </div>
    </div>
  );
}
